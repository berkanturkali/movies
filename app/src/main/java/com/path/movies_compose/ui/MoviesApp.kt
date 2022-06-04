package com.path.movies_compose.ui

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.examle.movies_compose.core.ui.theme.MoviesComposeTheme

@Composable
fun MoviesApp(windowSizeClass: WindowSizeClass) {

    MoviesComposeTheme {
        val navController = rememberNavController()
    }
}