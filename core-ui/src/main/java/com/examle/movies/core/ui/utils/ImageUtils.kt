package com.examle.movies.core.ui.utils

import android.content.Context
import android.util.LruCache
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.core.graphics.drawable.toBitmap
import androidx.palette.graphics.Palette
import coil.imageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import coil.size.Scale
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


@Composable
fun rememberDominantColorState(
    context: Context = LocalContext.current,
    defaultOnColor: Color = Color.Transparent,
    cacheSize: Int = 12,
    isColorValid: (Color) -> Boolean = { true }
): DominantColorState = remember {
    DominantColorState(context, defaultOnColor, cacheSize, isColorValid)
}

@Immutable
private data class DominantColors(val color: Color)

class DominantColorState(
    private val context: Context,
    private val defaultColor: Color,
    cacheSize: Int = 12,
    private val isColorValid: (Color) -> Boolean = { true }
) {
    var color by mutableStateOf(defaultColor)
        private set

    private val cache = when {
        cacheSize > 0 -> LruCache<String, DominantColors>(cacheSize)
        else -> null
    }

    suspend fun updateColorsFromImageUrl(url: String) {
        val result = calculateDominantColor(url)
        color = result?.color ?: defaultColor
    }

    private suspend fun calculateDominantColor(url: String): DominantColors? {
        val cached = cache?.get(url)
        if (cached != null) {
            return cached
        }
        return calculateSwatchesInImage(context, url)
            .sortedByDescending { swatch -> swatch.population }
            .firstOrNull { swatch -> isColorValid(Color(swatch.rgb)) }
            ?.let { swatch ->
                DominantColors(
                    color = Color(swatch.rgb),
                )
            }
            ?.also { result ->
                cache?.put(url, result)
            }

    }

    fun reset() {
        color = defaultColor
    }


    private suspend fun calculateSwatchesInImage(
        context: Context,
        imageUrl: String,
        size:Int = 128,
        maximumColorCount:Int = 8,
    ): List<Palette.Swatch> {

        val request = ImageRequest.Builder(context)
            .data(imageUrl)
            .size(size)
            .scale(Scale.FILL)
            .allowHardware(false)
            .memoryCacheKey("$imageUrl.palette")
            .build()

        val bitmap = when (val result = context.imageLoader.execute(request)) {
            is SuccessResult -> result.drawable.toBitmap()
            else -> null
        }

        return bitmap?.let {
            withContext(Dispatchers.Default) {
                val palette = Palette.Builder(bitmap)
                    .resizeBitmapArea(0)
                    .clearFilters()
                    .maximumColorCount(maximumColorCount)
                    .generate()
                palette.swatches
            }
        } ?: emptyList()

    }
}