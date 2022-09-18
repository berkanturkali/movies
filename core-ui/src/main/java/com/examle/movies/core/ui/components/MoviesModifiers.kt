package com.examle.movies.core.ui.components

import android.annotation.SuppressLint
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.fade
import com.google.accompanist.placeholder.material.placeholder


@SuppressLint("ComposableNaming")
fun Modifier.fadeModifier(isVisible: Boolean = true): Modifier = composed {
    placeholder(isVisible, highlight = PlaceholderHighlight.fade())
}