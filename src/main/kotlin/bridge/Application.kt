package bridge

import bridge.domain.Controller
import java.lang.IllegalArgumentException

fun main() {
    try {
        val controller = Controller()
        controller.run()
    } catch (e: IllegalArgumentException) {
        print(e.message)
    }
}
