plugins {
    id("movies.android.library")
    id("movies.android.feature")
    id("movies.android.library.compose")
    id("movies.android.library.jacoco")
    id("movies.spotless")
}

dependencies {

    //network
    implementAll(
        libs.retrofit.core,
        libs.retrofit.moshi.converter,
        libs.moshi,
        libs.okhttp.logging,
    )
}