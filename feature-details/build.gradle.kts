plugins {
    moviesAndroidLibrary
    moviesAndroidLibraryCompose
    moviesAndroidFeature
}

dependencies {

    implementation(Dependencies.Compose.COMPOSE_CONSTRAINT_LAYOUT)

    //coil
    implementation(Dependencies.Coil.COIL)
}