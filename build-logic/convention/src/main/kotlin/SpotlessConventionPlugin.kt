import org.gradle.api.Plugin
import org.gradle.api.Project
import org.revanth.app.configureSpotless
import org.revanth.app.spotlessGradle

/**
 * Plugin that applies the Spotless plugin and configures it.
 */
class SpotlessConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            applyPlugins()

            spotlessGradle {
                configureSpotless(this)
            }
        }
    }

    private fun Project.applyPlugins() {
        pluginManager.apply {
            apply("com.diffplug.spotless")
        }
    }
}