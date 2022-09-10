object Config {
    object Version {
        const val MIN_SDK_VERSION: Int = 21
        const val COMPILE_SDK_VERSION: Int = 32
        const val TARGET_SDK_VERSION: Int = 32

        const val VERSION_NAME: String = "1.0.0" //X.Y.Z; X = Major, Y = Minor, Z = Patch Level
        const val VERSION_CODE: Int = 1
    }

    object Android {
        const val APPLICATION_ID: String = "com.example.movies"
        const val TEST_INSTRUMENTATION_RUNNER: String = "androidx.test.runner.AndroidJUnitRunner"
        const val USE_SUPPORT_LIBRARY = true
    }
}