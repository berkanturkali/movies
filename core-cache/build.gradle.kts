plugins {
    moviesAndroidLibrary
    kotlinKapt
    daggerHilt
}

android {
    defaultConfig {
        javaCompileOptions {
            annotationProcessorOptions {
                arguments += Pair("room.incremental", "true")
            }
        }

        buildConfigField("int", "recentSearchesDatabaseVersion", 1.toString())
        buildConfigField("String", "recentSearchesDatabaseName", "\"recent_searches_db\"")
    }
}

dependencies {

    //libs
    implementAllProjects(
        ProjectLibs.CORE_MODEL
    )

    //room
    implementAll(
        Dependencies.Room.ROOM_KTX,
        Dependencies.Room.ROOM_RUNTIME,
        Dependencies.Room.ROOM_PAGING,
    )

    kapt(Dependencies.Room.ROOM_KAPT)

    //hilt
    implementation(Dependencies.DI.HILT_ANDROID)
    kapt(Dependencies.DI.HILT_COMPILER_KAPT)


    androidTestImplementation(Dependencies.Test.AndroidTest.TRUTH)

}