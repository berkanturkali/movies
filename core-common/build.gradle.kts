plugins {
    moviesAndroidLibrary
    daggerHilt
    kotlinKapt
}


dependencies {

    //hilt
    implementation(Dependencies.DI.HILT_ANDROID)
    kapt(Dependencies.DI.HILT_COMPILER_KAPT)
}