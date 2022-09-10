plugins {
    `kotlin-dsl`
}

group = "com.example.movies.build-logic"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.spotless.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("moviesAndroidApplicationCompose") {
            id = "movies.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("moviesAndroidApplication") {
            id = "movies.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("moviesAndroidApplicationJacoco") {
            id = "movies.android.application.jacoco"
            implementationClass = "AndroidApplicationJacocoConventionPlugin"
        }
        register("moviesAndroidLibraryCompose") {
            id = "movies.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("moviesAndroidLibrary") {
            id = "movies.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("moviesAndroidFeature") {
            id = "movies.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
        register("moviesAndroidLibraryJacoco") {
            id = "movies.android.library.jacoco"
            implementationClass = "AndroidLibraryJacocoConventionPlugin"
        }
        register("moviesSpotless") {
            id = "movies.spotless"
            implementationClass = "SpotlessConventionPlugin"
        }
    }
}