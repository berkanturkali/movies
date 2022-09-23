pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
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
include(":core-common")
