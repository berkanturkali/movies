import Dependencies.Accompanist.Version.ACCOMPANIST_VERSION
import Dependencies.AndroidX.Version.ANDROIDX_APPCOMPAT_VERSION
import Dependencies.AndroidX.Version.ANDROIDX_CORE_KTX_VERSION
import Dependencies.AndroidX.Version.ANDROIDX_CUSTOM_VIEW_VERSION
import Dependencies.Coil.Version.COIL_VERSION
import Dependencies.Compose.Version.COMPOSE_ACTIVITY_VERSION
import Dependencies.Compose.Version.COMPOSE_CONSTRAINT_LAYOUT_VERSION
import Dependencies.Compose.Version.COMPOSE_HILT_NAVIGATION_VERSION
import Dependencies.Compose.Version.COMPOSE_MATERIAL_3_VERSION
import Dependencies.Compose.Version.COMPOSE_MATERIAL_VERSION
import Dependencies.Compose.Version.COMPOSE_VERSION
import Dependencies.DI.Version.HILT_VERSION
import Dependencies.Lottie.Version.LOTTIE_VERSION
import Dependencies.Navigation.Version.NAVIGATION_COMPOSE_VERSION
import Dependencies.Network.Version.MOSHI_VERSION
import Dependencies.Network.Version.OKHTTP3_VERSION
import Dependencies.Network.Version.RETROFIT_VERSION
import Dependencies.Paging.Version.PAGING_3_VERSION
import Dependencies.Test.AndroidTest.Version.ANDROIDX_TEST_EXT_VERSION
import Dependencies.Test.AndroidTest.Version.ESPRESSO_CORE_VERSION
import Dependencies.Test.AndroidTest.Version.JUNIT_EXT_VERSION
import Dependencies.Test.UnitTest.Version.JUNIT_VERSION
import Dependencies.Test.UnitTest.Version.MOCKK_VERSION
import Dependencies.Test.UnitTest.Version.MOCK_WEB_SERVER_VERSION
import Dependencies.Test.UnitTest.Version.TRUTH_VERSION
import Dependencies.Timber.Version.TIMBER_VERSION
import GradlePlugins.Version.GRADLE_VERSION
import GradlePlugins.Version.KOTLIN_VERSION
import GradlePlugins.Version.SECRETS_VERSION

/**
 * Classpaths for project-level build.gradle
 */
object GradlePlugins {
    private object Version {
        const val KOTLIN_VERSION = "1.7.10"
        const val GRADLE_VERSION = "7.2.1"
        const val HILT_VERSION = "2.44"
        const val SECRETS_VERSION = "2.0.1"
    }

    const val KOTLIN_GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:$KOTLIN_VERSION"
    const val ANDROID_GRADLE_PLUGIN = "com.android.tools.build:gradle:$GRADLE_VERSION"
    const val HILT_GRADLE_PLUGIN =
        "com.google.dagger:hilt-android-gradle-plugin:${Version.HILT_VERSION}"
    const val SECRETS_GRADLE_PLUGIN =
        "com.google.android.libraries.mapsplatform.secrets-gradle-plugin:secrets-gradle-plugin:$SECRETS_VERSION"
}

/**
 * App dependencies and dependency-related stuff
 */
object Dependencies {

    //region androidx dependencies
    object AndroidX {
        private object Version {
            const val ANDROIDX_CORE_KTX_VERSION = "1.8.0"
            const val ANDROIDX_APPCOMPAT_VERSION = "1.5.0"
            const val ANDROIDX_CUSTOM_VIEW_VERSION = "1.0.0"
        }

        const val ANDROIDX_CORE_KTX = "androidx.core:core-ktx:$ANDROIDX_CORE_KTX_VERSION"
        const val ANDROIDX_APPCOMPAT = "androidx.appcompat:appcompat:$ANDROIDX_APPCOMPAT_VERSION"
        const val ANDROIDX_CUSTOM_VIEW_POOL_CONTAINER =
            "androidx.customview:customview-poolingcontainer:$ANDROIDX_CUSTOM_VIEW_VERSION"
    }
    //endregion

    //region compose-dependencies
    object Compose {
        internal object Version {
            const val COMPOSE_VERSION = "1.2.1"
            const val COMPOSE_ACTIVITY_VERSION = "1.6.0"
            const val COMPOSE_CONSTRAINT_LAYOUT_VERSION = "1.0.1"
            const val COMPOSE_HILT_NAVIGATION_VERSION = "1.0.0"
            const val COMPOSE_MATERIAL_3_VERSION = "1.0.0-beta03"
            const val COMPOSE_MATERIAL_VERSION = "1.2.1"
        }

        const val COMPOSE_FOUNDATION = "androidx.compose.foundation:foundation:$COMPOSE_VERSION"
        const val COMPOSE_FOUNDATION_LAYOUT =
            "androidx.compose.foundation:foundation-layout:$COMPOSE_VERSION"
        const val COMPOSE_MATERIAL_ICONS_EXTENDED =
            "androidx.compose.material:material-icons-extended:$COMPOSE_VERSION"
        const val COMPOSE_MATERIAL = "androidx.compose.material:material:$COMPOSE_MATERIAL_VERSION"
        const val COMPOSE_MATERIAL_3 =
            "androidx.compose.material3:material3:$COMPOSE_MATERIAL_3_VERSION"
        const val COMPOSE_MATERIAL_3_WINDOW_SIZE_CLASS =
            "androidx.compose.material3:material3-window-size-class:$COMPOSE_MATERIAL_3_VERSION"
        const val COMPOSE_RUNTIME = "androidx.compose.runtime:runtime:$COMPOSE_VERSION"
        const val COMPOSE_RUNTIME_LIVEDATA =
            "androidx.compose.runtime:runtime-livedata:$COMPOSE_VERSION"

        const val COMPOSE_UI_TEST_MANIFEST = "androidx.compose.ui:ui-test-manifest:$COMPOSE_VERSION"
        const val COMPOSE_UI_TOOLING = "androidx.compose.ui:ui-tooling:$COMPOSE_VERSION"
        const val COMPOSE_UI_TOOLING_PREVIEW =
            "androidx.compose.ui:ui-tooling-preview:$COMPOSE_VERSION"
        const val COMPOSE_CONSTRAINT_LAYOUT =
            "androidx.constraintlayout:constraintlayout-compose:$COMPOSE_CONSTRAINT_LAYOUT_VERSION"
        const val COMPOSE_UI_UTIL = "androidx.compose.ui:ui-util:$COMPOSE_VERSION"
        const val COMPOSE_ACTIVITY = "androidx.activity:activity-compose:$COMPOSE_ACTIVITY_VERSION"
        const val COMPOSE_HILT_NAVIGATION =
            "androidx.hilt:hilt-navigation-compose:$COMPOSE_HILT_NAVIGATION_VERSION"
    }
    //endregion

    //region accompanist-dependencies
    object Accompanist {
        private object Version {
            const val ACCOMPANIST_VERSION = "0.25.1"
        }

        const val ACCOMPANIST_ANIMATION =
            "com.google.accompanist:accompanist-navigation-animation:$ACCOMPANIST_VERSION"
        const val ACCOMPANIST_MATERIAL =
            "com.google.accompanist:accompanist-navigation-material:$ACCOMPANIST_VERSION"
        const val ACCOMPANIST_SWIPE_REFRESH =
            "com.google.accompanist:accompanist-swiperefresh:$ACCOMPANIST_VERSION"
        const val ACCOMPANIST_SYSTEM_UI_CONTROLLER =
            "com.google.accompanist:accompanist-systemuicontroller:$ACCOMPANIST_VERSION"
        const val ACCOMPANIST_PLACEHOLDER_MATERIAL =
            "com.google.accompanist:accompanist-placeholder-material:$ACCOMPANIST_VERSION"
        const val ACCOMPANIST_PAGER =
            "com.google.accompanist:accompanist-pager:$ACCOMPANIST_VERSION"
        const val ACCOMPANIST_PAGER_INDICATORS =
            "com.google.accompanist:accompanist-pager-indicators:$ACCOMPANIST_VERSION"
    }
    //endregion

    //region network-dependencies
    object Network {
        private object Version {
            const val OKHTTP3_VERSION = "4.10.0"
            const val RETROFIT_VERSION = "2.9.0"
            const val MOSHI_VERSION = "1.14.0"
        }

        const val OKHTTP_BOM = "com.squareup.okhttp3:okhttp-bom:$OKHTTP3_VERSION"

        const val OKHTTP_3 = "com.squareup.okhttp3:okhttp"
        const val OKHTTP_3_LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor"
        const val RETROFIT = "com.squareup.retrofit2:retrofit:$RETROFIT_VERSION"
        const val RETROFIT_MOSHI_CONVERTER =
            "com.squareup.retrofit2:converter-moshi:$RETROFIT_VERSION"
        const val MOSHI = "com.squareup.moshi:moshi-kotlin:$MOSHI_VERSION"
    }
    //endregion

    //region di-dependencies
    object DI {
        private object Version {
            const val HILT_VERSION = "2.44"
        }

        const val HILT_ANDROID = "com.google.dagger:hilt-android:$HILT_VERSION"
        const val HILT_COMPILER_KAPT = "com.google.dagger:hilt-compiler:$HILT_VERSION"
    }
    //endregion

    //region navigation-dependencies
    object Navigation {
        private object Version {
            const val NAVIGATION_COMPOSE_VERSION = "2.5.2"
        }

        const val NAVIGATION_COMPOSE =
            "androidx.navigation:navigation-compose:$NAVIGATION_COMPOSE_VERSION"
    }
    //endregion

    //region paging dependencies
    object Paging {
        private object Version {
            const val PAGING_3_VERSION = "1.0.0-alpha16"
        }

        const val PAGING = "androidx.paging:paging-compose:$PAGING_3_VERSION"
    }
    //endregion

    //region coil
    object Coil {
        private object Version {
            const val COIL_VERSION = "2.2.1"
        }

        const val COIL = "io.coil-kt:coil-compose:$COIL_VERSION"
    }
    //endregion

    //region timber
    object Timber {
        private object Version {
            const val TIMBER_VERSION = "5.0.1"
        }

        const val TIMBER = "com.jakewharton.timber:timber:$TIMBER_VERSION"
    }
    //endregion

    //region lottie
    object Lottie {
        private object Version {
            const val LOTTIE_VERSION = "5.2.0"
        }

        const val LOTTIE = "com.airbnb.android:lottie-compose:$LOTTIE_VERSION"
    }
    //endregion

    object Test {
        //region unit-test deps
        object UnitTest {
            private object Version {
                const val JUNIT_VERSION = "4.13.2"
                const val TRUTH_VERSION = "1.1.3"
                const val MOCK_WEB_SERVER_VERSION = "4.10.0"
                const val MOCKK_VERSION = "1.12.4"
            }

            const val JUNIT = "junit:junit:$JUNIT_VERSION"
            const val TRUTH = "com.google.truth:truth:$TRUTH_VERSION"
            const val MOCK_WEB_SERVER =
                "com.squareup.okhttp3:mockwebserver:$MOCK_WEB_SERVER_VERSION"
            const val MOCKK = "io.mockk:mockk:$MOCKK_VERSION"
        }
        //endregion

        //region android-test deps
        object AndroidTest {
            private object Version {
                const val ESPRESSO_CORE_VERSION = "3.4.0"
                const val JUNIT_EXT_VERSION = "1.1.3"
                const val ANDROIDX_TEST_EXT_VERSION = "1.1.3"
                const val COMPOSE_VERSION = "1.2.1"
            }

            const val COMPOSE_UI_TEST =
                "androidx.compose.ui:ui-test-junit4:${Version.COMPOSE_VERSION}"

            const val JUNIT_EXT = "androidx.test.ext:junit:$JUNIT_EXT_VERSION"
            const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:$ESPRESSO_CORE_VERSION"
            const val ANDROIDX_TEST_EXT_RUNNER =
                "androidx.test.ext:junit-ktx:$ANDROIDX_TEST_EXT_VERSION"

        }
        //endregion
    }
}