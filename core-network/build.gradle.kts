plugins {
    moviesAndroidLibrary
    moviesAndroidLibraryCompose
    moviesAndroidFeature
    googleSecrets
}

android.defaultConfig.buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org/3/\"")
dependencies {

    //platform
    implementPlatform(Dependencies.Network.OKHTTP_BOM)

//    //network
    implementAll(
        Dependencies.Network.RETROFIT,
        Dependencies.Network.RETROFIT_MOSHI_CONVERTER,
        Dependencies.Network.MOSHI,
        Dependencies.Network.OKHTTP_3,
        Dependencies.Network.OKHTTP_3_LOGGING_INTERCEPTOR
    )
//    //unit-test
    implementAllUnitTests(
        Dependencies.Test.UnitTest.TRUTH,
        Dependencies.Test.UnitTest.MOCKK,
        Dependencies.Test.UnitTest.MOCK_WEB_SERVER,
    )
}