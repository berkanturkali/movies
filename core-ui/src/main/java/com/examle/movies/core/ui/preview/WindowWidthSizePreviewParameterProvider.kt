package com.examle.movies.core.ui.preview

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class WindowWidthSizePreviewParameterProvider : PreviewParameterProvider<WindowWidthSizeClassPreview> {
    override val values: Sequence<WindowWidthSizeClassPreview>
        get() = sequenceOf(
            WindowWidthSizeClassPreview.Compact,
            WindowWidthSizeClassPreview.Medium,
            WindowWidthSizeClassPreview.Expanded
        )
}

sealed class WindowWidthSizeClassPreview(val value: WindowWidthSizeClass) {
    object Compact : WindowWidthSizeClassPreview(WindowWidthSizeClass.Compact)
    object Medium : WindowWidthSizeClassPreview(WindowWidthSizeClass.Medium)
    object Expanded : WindowWidthSizeClassPreview(WindowWidthSizeClass.Expanded)
}