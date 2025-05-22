import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import org.jetbrains.compose.resources.configureWebResources
import org.revanth.app.shared.MyKMPAppSharedApp
import org.revanth.app.shared.di.initKoin

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    initKoin()

    configureWebResources {
        resourcePathMapping { path -> "./$path" }
    }

    CanvasBasedWindow(
        title = "MyKMPAppTemplate",
        canvasElementId = "ComposeTarget",
    ) {
        MyKMPAppSharedApp()
    }
}