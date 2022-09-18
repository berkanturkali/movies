plugins {
    id("movies.android.application")
    id("movies.android.application.compose")
    id("movies.android.application.jacoco")
    id("kotlin-kapt")
    id("movies.spotless")
}

android {
    defaultConfig {
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
       named(BuildType.Release.name){
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

    //project libs
    implementAllProjects(
        ProjectLibs.CORE_UI,
        ProjectLibs.CORE_NAVIGATION,
        ProjectLibs.CORE_NETWORK,
        ProjectLibs.CORE_DATA,
        ProjectLibs.CORE_COMMON,
        ProjectLibs.FEATURE_HOME,
        ProjectLibs.FEATURE_SEARCH,
        ProjectLibs.FEATURE_UPCOMING,
        ProjectLibs.FEATURE_DOWNLOADS,
        ProjectLibs.FEATURE_MORE,
        ProjectLibs.FEATURE_HOME,
    )

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.compose.material3.windowSizeClass)
    implementation(libs.androidx.window.manager)
    implementation(libs.material3)
    implementation(libs.androidx.profileinstaller)

    // androidx.test is forcing JUnit, 4.12. This forces it to use 4.13
    configurations.configureEach {
        resolutionStrategy {
            force(libs.junit4)
            // Temporary workaround for https://issuetracker.google.com/174733673
            force("org.objenesis:objenesis:2.6")
        }
    }
}