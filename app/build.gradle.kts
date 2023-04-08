plugins {
    moviesAndroidApplication
    moviesAndroidApplicationCompose
}

android {
    kapt {
        correctErrorTypes = true
    }
}
hilt {
    enableAggregatingTask = true
}

dependencies {

    //project libs
    implementAllProjects(
        ProjectLibs.CORE_UI,
        ProjectLibs.CORE_NAVIGATION,
        ProjectLibs.CORE_NETWORK,
        ProjectLibs.CORE_DATA,
        ProjectLibs.CORE_COMMON,
        ProjectLibs.CORE_MODEL,
        ProjectLibs.FEATURE_SEARCH,
        ProjectLibs.FEATURE_HOME,
    )
}