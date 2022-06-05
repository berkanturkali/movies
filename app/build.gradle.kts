plugins {
    id("movies_compose.android.application")
    id("movies_compose.android.application.compose")
    id("movies_compose.android.application.jacoco")
    kotlin("kapt")
    id("jacoco")
    id("movies_compose.spotless")
}

android {
    defaultConfig {
        applicationId  = "com.path.movies_compose"
        versionCode  = 1
        versionName  = "1.0"

        testInstrumentationRunner =  "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary =  true
        }
    }

    buildTypes {
        val debug by getting {
            applicationIdSuffix = ".debug"
        }
        val release by getting {
            isMinifyEnabled = true
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

    implementation(project(":core-ui"))
    implementation(project(":core-navigation"))

    //features
    implementation(project(":feature-home"))
    implementation(project(":feature-search"))
    implementation(project(":feature-upcomings"))
    implementation(project(":feature-downloads"))
    implementation(project(":feature-more"))

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