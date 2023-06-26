package plugin

import Config
import Dependencies
import ProjectLibs
import com.android.build.gradle.LibraryExtension
import debugImplementation
import detektPlugins
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
                apply("com.google.dagger.hilt.android")
                apply("io.gitlab.arturbosch.detekt")
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
                    ProjectLibs.CORE_DATA,
                    ProjectLibs.CORE_MODEL,
                    ProjectLibs.CORE_COMMON,
                )

                //hilt
                implementation(Dependencies.DI.HILT_ANDROID)
                kapt(Dependencies.DI.HILT_COMPILER_KAPT)
                implementation(Dependencies.Compose.COMPOSE_HILT_NAVIGATION)

                //accompanist navigation
                implementation(Dependencies.Accompanist.ACCOMPANIST_ANIMATION)


                // TODO : Remove this dependency once we upgrade to Android Studio Dolphin b/228889042
                // These dependencies are currently necessary to render Compose previews
                debugImplementation(Dependencies.AndroidX.ANDROIDX_CUSTOM_VIEW_POOL_CONTAINER)

                detektPlugins(Dependencies.TwitterComposeRules.TWITTER_COMPOSE_RULES)
            }
        }
    }
}