plugins {
    moviesAndroidLibrary
    kotlinKapt
}
dependencies {
    implementation(Dependencies.DI.HILT_ANDROID)
    kapt(Dependencies.DI.HILT_COMPILER_KAPT)

    implementation(
        Dependencies.Accompanist.ACCOMPANIST_ANIMATION,
    )
}