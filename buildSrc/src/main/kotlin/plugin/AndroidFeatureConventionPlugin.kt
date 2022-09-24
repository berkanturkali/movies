package plugin

import Config
import Dependencies
import ProjectLibs
import com.android.build.gradle.LibraryExtension
import debugImplementation
import implementAllProjects
import implementation
import kapt
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.kapt")
                apply("dagger.hilt.android.plugin")
            }
            extensions.configure<LibraryExtension> {
                defaultConfig {
                    testInstrumentationRunner =
                        Config.Android.TEST_INSTRUMENTATION_RUNNER
                }
            }

            dependencies {

                implementAllProjects(
                    ProjectLibs.CORE_UI,
                    ProjectLibs.CORE_NAVIGATION,
                    )

                //hilt
                implementation(Dependencies.DI.HILT_ANDROID)
                kapt(Dependencies.DI.HILT_COMPILER_KAPT)

                //accompanist navigation
                implementation(Dependencies.Accompanist.ACCOMPANIST_ANIMATION)


                // TODO : Remove this dependency once we upgrade to Android Studio Dolphin b/228889042
                // These dependencies are currently necessary to render Compose previews
                debugImplementation(Dependencies.AndroidX.ANDROIDX_CUSTOM_VIEW_POOL_CONTAINER)
            }
        }
    }
}