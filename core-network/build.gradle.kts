plugins {
    id("movies.android.library")
    id("movies.android.feature")
    id("movies.android.library.compose")
    id("movies.android.library.jacoco")
    id("movies.spotless")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
}

android.defaultConfig.buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org/3/\"")
dependencies {

    //network
    implementAll(
        libs.retrofit.core,
        libs.retrofit.moshi.converter,
        libs.moshi,
        libs.okhttp.logging,
    )
}