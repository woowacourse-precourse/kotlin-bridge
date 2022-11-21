package bridge.controller

import bridge.*
import bridge.view.InputView
import bridge.view.OutputView

class BridgeController {
    private val bridgeNumberGenerator = BridgeRandomNumberGenerator()

    fun run(){
        InputView().startPhrases()

        val size = BridgeMaker(bridgeNumberGenerator).printSize().toInt()

        var bridge = printBridge(size)
        println(bridge)
        println()

        choiceBridge(size)
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
        }catch (e : IllegalArgumentException){
            println(e)
            println("\n")
            val move = printDirection()
            return move
        }

    }

    fun choiceBridge(size : Int){
        for (part in 0 until size){
            val direction = printDirection()
            OutputView().printMap(direction , part)
        }

    }
}