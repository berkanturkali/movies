@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("movies_compose.android.library")
    id("movies_compose.android.library.jacoco")
    alias(libs.plugins.ksp)
    id("movies_compose.spotless")
}
dependencies {
    api(libs.androidx.hilt.navigation.compose)
    api(libs.androidx.navigation.compose)
}