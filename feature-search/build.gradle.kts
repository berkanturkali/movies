plugins {
    moviesAndroidLibrary
    moviesAndroidLibraryCompose
    moviesAndroidFeature
}


dependencies {
    //accompanist
    implementAll(
        Dependencies.Accompanist.ACCOMPANIST_SWIPE_REFRESH,
    )

    //coil
    implementation(Dependencies.Coil.COIL)

    //palette
    implementation(Dependencies.Palette.PALETTE)
}