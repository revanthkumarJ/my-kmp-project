
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.revanth.app.configureFlavors
import org.revanth.app.configureKotlinAndroid
import org.revanth.app.configureKotlinMultiplatform
import org.revanth.app.libs

/**
 * Plugin that applies the Android library and Kotlin multiplatform plugins and configures them.
 */
class KMPLibraryConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.multiplatform")
                apply("org.revanth.app.kmp.koin")
                apply("org.revanth.app.detekt.plugin")
                apply("org.revanth.app.spotless.plugin")
            }

            configureKotlinMultiplatform()

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = 34
                configureFlavors(this)
                // The resource prefix is derived from the module name,
                // so resources inside ":core:module1" must be prefixed with "core_module1_"
                resourcePrefix = path
                    .split("""\W""".toRegex())
                    .drop(1).distinct()
                    .joinToString(separator = "_")
                    .lowercase() + "_"
            }

            dependencies {
                add("commonTestImplementation", libs.findLibrary("kotlin.test").get())
                add("commonTestImplementation", libs.findLibrary("kotlinx.coroutines.test").get())
            }
        }
    }
}