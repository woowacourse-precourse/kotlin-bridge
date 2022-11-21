package bridge.controller

import bridge.*
import bridge.view.InputView
import bridge.view.OutputView

class BridgeController {
    private val bridgeNumberGenerator = BridgeRandomNumberGenerator()
    val resultUp = StringBuilder()
    val resultDown = StringBuilder()

    fun run() {
        InputView().startPhrases()

        val size = BridgeMaker(bridgeNumberGenerator).printSize().toInt()

        var bridge = printBridge(size)
        println(bridge)
        println()

        choiceBridge(size, bridge)
    }

    fun printBridge(num: Int): List<String> {

        var arr = arrayListOf<String>()
        arr = BridgeMaker(bridgeNumberGenerator).makeBridge(num) as ArrayList<String>

        return arr
    }

    fun printDirection(): String {
        try {
            val move = InputView().readMoving()
            CheckException().checkInputDirection(move)
            return move
        } catch (e: IllegalArgumentException) {
            println(e)
            println("\n")
            val move = printDirection()
            return move
        }

    }

    fun choiceBridge(size: Int, bridge: List<String>) {

        for (part in 0 until size) {
            var direction = printDirection()

            if (direction == "U") {
                val answer = BridgeGame().move(direction, bridge[part])
                OutputView().printMap(answer.toString(), part, resultUp)
                OutputView().printMap(" ", part, resultDown)
                InputView().readGameCommand(answer.toString())
            }
            if (direction == "D") {
                val answer = BridgeGame().move(direction, bridge[part])
                OutputView().printMap(" ", part, resultUp)
                OutputView().printMap(answer.toString(), part, resultDown)
                InputView().readGameCommand(answer.toString())
            }

            println()
        }
    }

}