package bridge

import model.BridgeGame
import controller.Controller
import utils.Messages.ERROR_PREFIX

fun main() {
    try {
        Controller().run()
    } catch (error: IllegalArgumentException) {
        println(ERROR_PREFIX+error.message)
    }
}
