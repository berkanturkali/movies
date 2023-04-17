import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

val PluginDependenciesSpec.moviesAndroidApplication: PluginDependencySpec
    get() = id("movies.android.application")

val PluginDependenciesSpec.moviesAndroidApplicationCompose: PluginDependencySpec
    get() = id("movies.android.application.compose")

val PluginDependenciesSpec.moviesAndroidLibrary: PluginDependencySpec
    get() = id("movies.android.library")

val PluginDependenciesSpec.moviesAndroidLibraryCompose: PluginDependencySpec
    get() = id("movies.android.library.compose")

val PluginDependenciesSpec.moviesAndroidFeature: PluginDependencySpec
    get() = id("movies.android.feature")

val PluginDependenciesSpec.daggerHilt: PluginDependencySpec
    get() = id("com.google.dagger.hilt.android")

val PluginDependenciesSpec.parcelize: PluginDependencySpec
    get() = id("kotlin-parcelize")

val PluginDependenciesSpec.kotlinKapt: PluginDependencySpec
    get() = id("org.jetbrains.kotlin.kapt")

val PluginDependenciesSpec.googleSecrets: PluginDependencySpec
    get() = id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")

fun DependencyHandler.kapt(dependency: Any) = add(
    "kapt", dependency
)

fun DependencyHandler.implementation(dependency: Any) = add(
    "implementation", dependency
)

fun DependencyHandler.implementAll(vararg dependencies: Any) {
    dependencies.forEach(::implementation)
}

fun DependencyHandler.implementProject(projectLib: String) = add(
    "implementation", project(projectLib)
)

fun DependencyHandler.implementAllProjects(vararg projectLibs: String) {
    projectLibs.forEach(::implementProject)
}

fun DependencyHandler.implementPlatform(dependency: Any) = add(
    "implementation", platform(dependency)
)

fun DependencyHandler.testImplementation(dependency: Any) = add(
    "testImplementation", dependency
)

fun DependencyHandler.implementAllUnitTests(vararg dependencies: Any) {
    dependencies.forEach(::testImplementation)
}

fun DependencyHandler.androidTestImplementation(dependency: Any) = add(
    "androidTestImplementation", dependency
)

fun DependencyHandler.implementAllAndroidTests(vararg dependencies: Any) {
    dependencies.forEach(::androidTestImplementation)
}

fun DependencyHandler.debugImplementation(dependency: Any) = add(
    "debugImplementation", dependency
)

fun DependencyHandler.api(dependency: Any) = add(
    "api", dependency
)

fun DependencyHandler.apiAllDeps(vararg dependencies: Any) {
    dependencies.forEach(::api)
}
