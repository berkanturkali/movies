plugins {
    moviesAndroidLibrary
    kotlinKapt
}


dependencies {

    //room
    implementAll(
        Dependencies.Room.ROOM_KTX,
        Dependencies.Room.ROOM_RUNTIME,
        Dependencies.Room.ROOM_PAGING
    )

    kapt(Dependencies.Room.ROOM_KAPT)
}