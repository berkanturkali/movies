plugins {
    moviesAndroidLibrary
    googleSecrets
    kotlinKapt
}

android.defaultConfig.buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org/3/\"")
android.defaultConfig.buildConfigField(
    "String",
    "BASE_IMAGE_URL",
    "\"https://image.tmdb.org/t/p/\""
)
dependencies {

    //project libs
    implementAllProjects(
        ProjectLibs.CORE_MODEL,
    )

    //hilt
    implementation(Dependencies.DI.HILT_ANDROID)
    kapt(Dependencies.DI.HILT_COMPILER_KAPT)

    //platform
    implementPlatform(Dependencies.Network.OKHTTP_BOM)

    //network
    implementAll(
        Dependencies.Network.RETROFIT,
        Dependencies.Network.RETROFIT_MOSHI_CONVERTER,
        Dependencies.Network.MOSHI,
        Dependencies.Network.OKHTTP_3,
        Dependencies.Network.OKHTTP_3_LOGGING_INTERCEPTOR
    )

    //paging-3
    implementation(
        Dependencies.Paging.PAGING
    )
    //unit-test
    implementAllUnitTests(
        Dependencies.Test.UnitTest.TRUTH,
        Dependencies.Test.UnitTest.MOCKK,
        Dependencies.Test.UnitTest.MOCK_WEB_SERVER,
    )
}