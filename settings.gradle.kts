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
rootProject.name = "Movies"
include (":app")
include(":core-ui")
include(":core-navigation")
include(":feature-home")
include(":feature-search")
include(":feature-upcomings")
include(":feature-downloads")
include(":feature-more")
include(":core-network")
include(":core-data")
