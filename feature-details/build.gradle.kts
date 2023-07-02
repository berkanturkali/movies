plugins {
    moviesAndroidLibrary
    moviesAndroidLibraryCompose
    moviesAndroidFeature
}

dependencies {

    implementation(Dependencies.Compose.COMPOSE_CONSTRAINT_LAYOUT)

    //coil
    implementation(Dependencies.Coil.COIL)

    //paging-3
    implementation(Dependencies.Paging.PAGING)

    //exoplayer
    implementAll(
        Dependencies.ExoPlayer.EXO_PLAYER,
        Dependencies.ExoPlayer.EXO_PLAYER_UI
    )
}