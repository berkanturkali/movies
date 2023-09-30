plugins {
    moviesAndroidLibrary
    kotlinKapt
    parcelize
}
dependencies {

    implementProject(ProjectLibs.CORE_MODEL)

    implementation(Dependencies.DI.HILT_ANDROID)
    kapt(Dependencies.DI.HILT_COMPILER_KAPT)

    implementation(
        Dependencies.Accompanist.ACCOMPANIST_ANIMATION,
    )

    implementation(Dependencies.Network.MOSHI)
}