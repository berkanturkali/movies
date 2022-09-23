package plugin

import com.android.build.gradle.LibraryExtension
import com.example.movies.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import implementAll
import testImplementation
import implementAllAndroidTests

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
                )

            }
        }
    }
}