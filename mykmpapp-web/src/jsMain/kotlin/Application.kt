import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import org.jetbrains.skiko.wasm.onWasmReady
import org.revanth.app.shared.MyKMPAppSharedApp
import org.revanth.app.shared.di.initKoin

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    initKoin()

    onWasmReady {
        ComposeViewport(document.body!!) {
            MyKMPAppSharedApp()
        }
    }
}