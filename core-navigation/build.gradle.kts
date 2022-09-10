@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("movies.android.library")
    id("movies.android.library.jacoco")
    alias(libs.plugins.ksp)
    id("movies.spotless")
}
dependencies {
    api(libs.androidx.hilt.navigation.compose)
    api(libs.androidx.navigation.compose)
}