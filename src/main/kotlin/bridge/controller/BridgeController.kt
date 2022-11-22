package bridge.controller

import bridge.*
import bridge.exception.CheckException
import bridge.exception.PrintException
import bridge.view.InputView
import bridge.view.OutputView

class BridgeController {
    private val bridgeNumberGenerator = BridgeRandomNumberGenerator()
    val resultUp = StringBuilder()
    val resultDown = StringBuilder()

    fun run() {
        InputView().startPhrases()

        val size = PrintException().printSize().toInt()

        var bridge = PrintException().printBridge(size)
        println(bridge)
        println()

        choiceBridge(size, bridge)
    }


    fun choiceBridge(size: Int, bridge: List<String>) {

        for (part in 0 until size) {
            var direction = PrintException().printDirection()
            if (direction == "U") {
                val answer = BridgeGame().move(direction, bridge[part])
                OutputView().printMap(answer.toString(), part, resultUp)
                OutputView().printMap(" ", part, resultDown)
            }
            if (direction == "D") {
                val answer = BridgeGame().move(direction, bridge[part])
                OutputView().printMap(" ", part, resultUp)
                OutputView().printMap(answer.toString(), part, resultDown)
            }
            println()
        }
    }


}