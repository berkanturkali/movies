plugins {
    moviesAndroidApplication
    moviesAndroidApplicationCompose
    kotlinKapt
    daggerHilt
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
    kapt {
        correctErrorTypes = true
    }
}
hilt {
    enableAggregatingTask = true
}


dependencies {

    //project libs
    implementAllProjects(
        ProjectLibs.CORE_UI,
        ProjectLibs.CORE_NAVIGATION,
        ProjectLibs.CORE_NETWORK,
        ProjectLibs.CORE_DATA,
        ProjectLibs.CORE_COMMON,
        ProjectLibs.CORE_MODEL,
        ProjectLibs.FEATURE_SEARCH,
        ProjectLibs.FEATURE_HOME,
    )
    implementation(Dependencies.Compose.COMPOSE_ACTIVITY)
    implementation(Dependencies.AndroidX.ANDROIDX_APPCOMPAT)
    implementation(Dependencies.AndroidX.ANDROIDX_CORE_KTX)

    //accompanist
    implementation(Dependencies.Accompanist.ACCOMPANIST_ANIMATION)

    //hilt
    implementation(Dependencies.DI.HILT_ANDROID)
    kapt(Dependencies.DI.HILT_COMPILER_KAPT)

    //timber
    implementation(Dependencies.Timber.TIMBER)
}