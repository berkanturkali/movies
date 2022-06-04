
buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(libs.android.gradlePlugin)
        classpath(libs.kotlin.gradlePlugin)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
//        classpath(libs.kotlin.serializationPlugin)
//        classpath(libs.hilt.gradlePlugin)
//        classpath(libs.secrets.gradlePlugin)
    }
}