package com.examle.movies.core.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.fade
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.shimmer


@SuppressLint("ComposableNaming")
fun Modifier.fadeModifier(isVisible: Boolean = true): Modifier = composed {
    placeholder(isVisible, highlight = PlaceholderHighlight.fade(highlightColor = Color.LightGray))
}

fun Modifier.shimmerModifier(isVisible: Boolean = true): Modifier = composed {
    placeholder(
        visible = isVisible,
        highlight = PlaceholderHighlight.shimmer(highlightColor = Color.LightGray)
    )
}

@SuppressLint("ComposableNaming")
@Composable
fun Modifier.noRippleModifier(onClick: () -> Unit): Modifier {
    this.clickable(
        interactionSource = remember {
            MutableInteractionSource()
        },
        indication = null

    ) {
        onClick()
    }
    return this
}