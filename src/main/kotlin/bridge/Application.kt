package bridge

import java.lang.IllegalArgumentException

fun main() {
    try {
        val controller = Controller()
        controller.run()
    } catch (e: IllegalArgumentException) {
        print(e.message)
    }
}
