plugins {
    moviesAndroidLibrary
    moviesAndroidLibraryCompose
}

dependencies {
    implementation(Dependencies.AndroidX.ANDROIDX_CORE_KTX)
    implementation(Dependencies.Coil.COIL)
    implementation(Dependencies.Accompanist.ACCOMPANIST_PLACEHOLDER_MATERIAL)


    api(Dependencies.Compose.COMPOSE_FOUNDATION)
    api(Dependencies.Compose.COMPOSE_FOUNDATION_LAYOUT)
    api(Dependencies.Compose.COMPOSE_MATERIAL_ICONS_EXTENDED)
    api(Dependencies.Compose.COMPOSE_MATERIAL_3)
    api(Dependencies.Compose.COMPOSE_MATERIAL)
    debugApi(Dependencies.Compose.COMPOSE_UI_TOOLING)
    api(Dependencies.Compose.COMPOSE_UI_TOOLING_PREVIEW)
    api(Dependencies.Compose.COMPOSE_UI_UTIL)
    api(Dependencies.Compose.COMPOSE_RUNTIME)
    api(Dependencies.Compose.COMPOSE_RUNTIME_LIVEDATA)
    api(Dependencies.Compose.COMPOSE_CONSTRAINT_LAYOUT)
    api(Dependencies.Compose.COMPOSE_MATERIAL_3_WINDOW_SIZE_CLASS)

    // TODO : Remove these dependency once we upgrade to Android Studio Dolphin b/228889042
    // These dependencies are currently necessary to render Compose previews
    debugImplementation(Dependencies.AndroidX.ANDROIDX_CUSTOM_VIEW_POOL_CONTAINER)
}