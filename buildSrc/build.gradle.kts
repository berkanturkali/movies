plugins {
    `kotlin-dsl`
}

repositories{
    google()
    mavenCentral()
    maven("https://plugins.gradle.org/m2/")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(Plugin.KOTLIN_GRADLE_PLUGIN)
    implementation(Plugin.ANDROID_GRADLE_PLUGIN)
    implementation(Plugin.HILT_GRADLE_PLUGIN)
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
        const val KOTLIN_VERSION = "1.7.10"
        const val GRADLE_VERSION = "7.2.1"
        const val HILT_VERSION = "2.43"
    }

    const val KOTLIN_GRADLE_PLUGIN: String =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.KOTLIN_VERSION}"
    const val ANDROID_GRADLE_PLUGIN: String = "com.android.tools.build:gradle:${Version.GRADLE_VERSION}"
    const val HILT_GRADLE_PLUGIN =
        "com.google.dagger:hilt-android-gradle-plugin:${Version.HILT_VERSION}"

}