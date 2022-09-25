plugins {
    moviesAndroidLibrary
}

dependencies {
    //project libs
    implementAllProjects(
        ProjectLibs.CORE_MODEL,
        ProjectLibs.CORE_COMMON,
        ProjectLibs.CORE_NETWORK,
    )

    //network
    implementAll(
        Dependencies.Network.RETROFIT,
        Dependencies.Network.MOSHI
    )
}