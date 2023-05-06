plugins {
    moviesAndroidLibrary
    moviesAndroidLibraryCompose
    moviesAndroidFeature
}


dependencies {
    //accompanist
    implementAll(
        Dependencies.Accompanist.ACCOMPANIST_SWIPE_REFRESH,
        Dependencies.Accompanist.ACCOMPANIST_PAGER
    )

    //coil
    implementation(Dependencies.Coil.COIL)

    //palette
    implementation(Dependencies.Palette.PALETTE)

    //paging3
    implementation(Dependencies.Paging.PAGING)

    //lifecycle
    implementation(Dependencies.Lifecycle.LIFECYCLE_LIVEDATA_KTX)

    //unit tests
    implementAllUnitTests(
        Dependencies.Test.UnitTest.TRUTH
    )
}