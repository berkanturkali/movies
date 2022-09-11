package com.examle.movies.core.ui.providers

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.core.app.ComponentActivity

val LocalActivity = staticCompositionLocalOf<ComponentActivity> {
    noLocalProvidedFor("LocalActivity")
}

val LocalWindowSizeClass = staticCompositionLocalOf<WindowSizeClass> {
    noLocalProvidedFor("WindowSizeClass")
}

private fun noLocalProvidedFor(name: String): Nothing {
    error("CompositionLocal $name not present")
}
