package com.examle.movies.core.ui.components

import android.annotation.SuppressLint
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.fade
import com.google.accompanist.placeholder.material.fade
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmer


@SuppressLint("ComposableNaming")
fun Modifier.fadeModifier(isVisible: Boolean = true): Modifier = composed {
    placeholder(isVisible, highlight = PlaceholderHighlight.fade(highlightColor = Color.LightGray))
}