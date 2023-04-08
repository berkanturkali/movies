package plugin

import BuildType
import Config
import Dependencies
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.example.movies.configureKotlinAndroid
import implementation
import kapt
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.kapt")
                apply("com.google.dagger.hilt.android")
            }

            extensions.configure<BaseAppModuleExtension> {
                configureKotlinAndroid(this)
                defaultConfig {
                    targetSdk = Config.Version.TARGET_SDK_VERSION
                    applicationId = Config.Android.APPLICATION_ID
                    versionCode = Config.Version.VERSION_CODE
                    versionName = Config.Version.VERSION_NAME
                    testInstrumentationRunner = Config.Android.TEST_INSTRUMENTATION_RUNNER
                    vectorDrawables {
                        useSupportLibrary = Config.Android.USE_SUPPORT_LIBRARY
                    }
                }
                buildTypes {
                    named(BuildType.Debug.name) {
                        applicationIdSuffix = BuildType.Debug.applicationIdSuffix
                    }
                    named(BuildType.Release.name) {
                        isMinifyEnabled = BuildType.Release.isMinifyEnabled
                        proguardFiles(
                            getDefaultProguardFile("proguard-android-optimize.txt"),
                            "proguard-rules.pro"
                        )
                    }
                }
                packagingOptions {
                    resources {
                        excludes.add("/META-INF/{AL2.0,LGPL2.1}")
                    }
                }
                testOptions {
                    unitTests {
                        isIncludeAndroidResources = true
                    }
                }
            }


            dependencies {

                implementation(Dependencies.Compose.COMPOSE_ACTIVITY)
                implementation(Dependencies.AndroidX.ANDROIDX_APPCOMPAT)
                implementation(Dependencies.AndroidX.ANDROIDX_CORE_KTX)

                //accompanist
                implementation(Dependencies.Accompanist.ACCOMPANIST_ANIMATION)

                //timber
                implementation(Dependencies.Timber.TIMBER)

                //hilt
                implementation(Dependencies.DI.HILT_ANDROID)
                kapt(Dependencies.DI.HILT_COMPILER_KAPT)

            }
        }
    }

}