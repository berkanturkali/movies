package com.example.movies

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

/**
 * Configure Compose-specific options
 */
internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *>,
) {
    commonExtension.apply {
        buildFeatures.compose = true

        composeOptions {
            kotlinCompilerExtensionVersion = "1.3.1"
        }

        kotlinOptions {
            // Treat all Kotlin warnings as errors (disabled by default)
            allWarningsAsErrors = properties["warningsAsErrors"] as? Boolean ?: false

            freeCompilerArgs = freeCompilerArgs + (
                    "-opt-in=kotlin.Experimental," +
                            "androidx.compose.ui.ExperimentalComposeUiApi," +
                            "com.google.accompanist.pager.ExperimentalPagerApi," +
                            "com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi," +
                            "androidx.compose.material.ExperimentalMaterialApi," +
                            "androidx.compose.animation.ExperimentalAnimationApi," +
                            "androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi," +
                            "androidx.compose.material3.ExperimentalMaterial3Api,"
                    )

            // Set JVM target to 1.8
            jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
    }
}

private fun CommonExtension<*, *, *, *>.kotlinOptions(block: KotlinJvmOptions.() -> Unit) {
    (this as ExtensionAware).extensions.configure("kotlinOptions", block)
}
