pluginManagement {
    includeBuild("build-logic")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    enableFeaturePreview("VERSION_CATALOGS")
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Movies-Compose"
include (":app")
