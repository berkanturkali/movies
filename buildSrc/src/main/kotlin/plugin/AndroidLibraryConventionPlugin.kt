package plugin

import Config
import Dependencies
import com.android.build.gradle.LibraryExtension
import com.example.movies.configureKotlinAndroid
import implementAll
import implementAllAndroidTests
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import testImplementation

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = Config.Version.TARGET_SDK_VERSION
                defaultConfig.testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }
            dependencies {
                implementAll(
                    Dependencies.AndroidX.ANDROIDX_CORE_KTX,
                    Dependencies.AndroidX.ANDROIDX_APPCOMPAT,
                    Dependencies.Timber.TIMBER,
                )
                testImplementation(
                    Dependencies.Test.UnitTest.JUNIT,
                )

                implementAllAndroidTests(
                    Dependencies.Test.AndroidTest.ANDROIDX_TEST_EXT_RUNNER,
                    Dependencies.Test.AndroidTest.ESPRESSO_CORE,
                    Dependencies.Test.AndroidTest.JUNIT,
                    Dependencies.Test.AndroidTest.JUNIT_EXT
                )

            }
        }
    }
}