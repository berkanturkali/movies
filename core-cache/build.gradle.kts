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
        buildConfigField("int", "keywordsDatabaseVersion", 1.toString())
        buildConfigField("String", "keywordsDatabaseName", "\"movies_keywords_db\"")
    }
}

dependencies {

    //room
    implementAll(
        Dependencies.Room.ROOM_KTX,
        Dependencies.Room.ROOM_RUNTIME,
        Dependencies.Room.ROOM_PAGING
    )

    kapt(Dependencies.Room.ROOM_KAPT)

    implementation(Dependencies.DI.HILT_ANDROID)
    kapt(Dependencies.DI.HILT_COMPILER_KAPT)
}