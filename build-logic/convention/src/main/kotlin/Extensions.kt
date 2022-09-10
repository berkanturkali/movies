import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

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
