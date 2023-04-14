plugins {
    moviesAndroidLibrary
    kotlinKapt
    daggerHilt
}

android {
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    //project libs
    implementAllProjects(
        ProjectLibs.CORE_MODEL,
        ProjectLibs.CORE_COMMON,
        ProjectLibs.CORE_NETWORK,
        ProjectLibs.CORE_CACHE
    )

    //network
    implementAll(
        Dependencies.Network.RETROFIT,
        Dependencies.Network.MOSHI
    )

    //hilt
    implementation(Dependencies.DI.HILT_ANDROID)
    kapt(Dependencies.DI.HILT_COMPILER_KAPT)

    //paging-3
    implementation(Dependencies.Paging.PAGING)


    testImplementation(Dependencies.Test.UnitTest.TRUTH)
}