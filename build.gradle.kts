buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath(GradlePlugins.ANDROID_GRADLE_PLUGIN)
        classpath(GradlePlugins.KOTLIN_GRADLE_PLUGIN)
        classpath(GradlePlugins.HILT_GRADLE_PLUGIN)
        classpath(GradlePlugins.SECRETS_GRADLE_PLUGIN)
    }
}