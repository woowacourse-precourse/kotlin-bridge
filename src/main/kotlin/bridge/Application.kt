package bridge

import bridge.controller.Controller

fun main() {
    Controller().run(BridgeRandomNumberGenerator())
}
