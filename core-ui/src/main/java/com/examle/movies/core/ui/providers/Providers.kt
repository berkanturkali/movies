package com.examle.movies.core.ui.providers

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.core.app.ComponentActivity

val LocalActivity = staticCompositionLocalOf<ComponentActivity> {
    noLocalProvidedFor("LocalActivity")
}

val LocalWindowWidthSizeClass = compositionLocalOf<WindowWidthSizeClass> {
    noLocalProvidedFor("WindowWidthSizeClass")
}

val LocalSearchQuery = compositionLocalOf<String> {
    noLocalProvidedFor("SearchQuery")
}

private fun noLocalProvidedFor(name: String): Nothing {
    error("CompositionLocal $name not present")
}
