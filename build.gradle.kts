plugins {
    id("io.gitlab.arturbosch.detekt") version ("1.23.0")
}
buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
    }
}
detekt {
    toolVersion = "1.23.0"
    config.setFrom(file("config/detekt/detekt.yml"))
    buildUponDefaultConfig = true
}
