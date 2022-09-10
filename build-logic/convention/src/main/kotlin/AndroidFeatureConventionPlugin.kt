import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.kapt")
                apply("dagger.hilt.android.plugin")
            }
            extensions.configure<LibraryExtension> {
                defaultConfig {
                    testInstrumentationRunner =
                        Config.Android.TEST_INSTRUMENTATION_RUNNER
                }
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            dependencies {

                implementAllProjects(
                    ProjectLibs.CORE_UI,
                    ProjectLibs.CORE_NAVIGATION,

                    )
//                add("implementation", project(":core-model"))
//                add("implementation", project(":core-data"))
//                add("implementation", project(":core-common"))

                implementAll(
                    libs.findLibrary("androidx.hilt.navigation.compose").get(),
                    libs.findLibrary("androidx.lifecycle.viewModelCompose").get(),
                    libs.findLibrary("kotlinx.coroutines.android").get(),
                    libs.findLibrary("hilt.android").get(),
                    libs.findLibrary("coil.kt.compose").get(),

                    )
                kapt(libs.findLibrary("hilt.compiler").get())

                // TODO : Remove this dependency once we upgrade to Android Studio Dolphin b/228889042
                // These dependencies are currently necessary to render Compose previews
                debugImplementation(libs.findLibrary("androidx.customview.poolingcontainer").get())
            }
        }
    }
}