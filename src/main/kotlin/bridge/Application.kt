package bridge

import bridge.controller.Controller
import java.lang.IllegalArgumentException

fun main() {
    try {
        val controller = Controller()
        controller.run()
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}
