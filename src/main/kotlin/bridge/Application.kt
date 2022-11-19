package bridge

import bridge.controller.Controller
import bridge.util.BridgeRandomNumberGenerator

fun main() {
    Controller().run(BridgeRandomNumberGenerator())
}
