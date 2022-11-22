package bridge.exception

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import bridge.view.InputView

class PrintException {


    fun printSize(): String {
        try {
            val size = InputView().readBridgeSize()
            CheckException().checkInputSize(size)
            return size
        } catch (e: IllegalArgumentException) {
            println(e)
            println("\n")
            val size = printSize()
            return size
        }
    }

    fun printBridge(num: Int): List<String> {
        val bridgeNumberGenerator = BridgeRandomNumberGenerator()
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

    fun printRestart() : String?{
        try {
            val restart = InputView().readGameCommand()
            CheckException().checkInputRestart(restart.toString())
            return restart
        } catch (e: IllegalArgumentException) {
            println(e)
            println("\n")
            val restart = printRestart()
            return restart
        }
    }

}