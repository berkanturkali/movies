import Build_gradle.Plugin.Version.SECRETS_VERSION

plugins {
    `kotlin-dsl`
//    `kotlin-dsl-precompiled-script-plugins`
}

repositories{
    google()
    mavenCentral()
    maven("https://plugins.gradle.org/m2/")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}



gradlePlugin {
    plugins {
        register("moviesAndroidApplicationCompose") {
            id = "movies.android.application.compose"
            implementationClass = "plugin.AndroidApplicationComposeConventionPlugin"
        }
        register("moviesAndroidApplication") {
            id = "movies.android.application"
            implementationClass = "plugin.AndroidApplicationConventionPlugin"
        }
        register("moviesAndroidLibraryCompose") {
            id = "movies.android.library.compose"
            implementationClass = "plugin.AndroidLibraryComposeConventionPlugin"
        }
        register("moviesAndroidLibrary") {
            id = "movies.android.library"
            implementationClass = "plugin.AndroidLibraryConventionPlugin"
        }
        register("moviesAndroidFeature") {
            id = "movies.android.feature"
            implementationClass = "plugin.AndroidFeatureConventionPlugin"
        }
    }
}

object Plugin {
    private object Version {
        const val KOTLIN_VERSION = "1.8.20"
        const val GRADLE_VERSION = "7.4.2"
        const val HILT_VERSION = "2.44"
        const val SECRETS_VERSION = "2.0.1"
    }

    const val KOTLIN_GRADLE_PLUGIN: String =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.KOTLIN_VERSION}"
    const val ANDROID_GRADLE_PLUGIN: String = "com.android.tools.build:gradle:${Version.GRADLE_VERSION}"
    const val HILT_GRADLE_PLUGIN =
        "com.google.dagger:hilt-android-gradle-plugin:${Version.HILT_VERSION}"
    const val SECRETS_GRADLE_PLUGIN =
        "com.google.android.libraries.mapsplatform.secrets-gradle-plugin:secrets-gradle-plugin:$SECRETS_VERSION"

}
dependencies {
    implementation(Plugin.KOTLIN_GRADLE_PLUGIN)
    implementation(Plugin.ANDROID_GRADLE_PLUGIN)
    implementation(Plugin.HILT_GRADLE_PLUGIN)
    implementation(Plugin.SECRETS_GRADLE_PLUGIN)
}