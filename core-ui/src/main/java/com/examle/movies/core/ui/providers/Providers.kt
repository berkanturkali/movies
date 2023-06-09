package com.examle.movies.core.ui.providers

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.compositionLocalOf

val LocalWindowWidthSizeClass = compositionLocalOf<WindowWidthSizeClass> {
    noLocalProvidedFor("WindowWidthSizeClass")
}

val LocalSearchQuery = compositionLocalOf<String> {
    noLocalProvidedFor("SearchQuery")
}

private fun noLocalProvidedFor(name: String): Nothing {
    error("CompositionLocal $name not present")
}
