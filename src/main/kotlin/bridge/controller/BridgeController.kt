package bridge.controller

import bridge.*
import bridge.exception.CheckException
import bridge.exception.PrintException
import bridge.view.InputView
import bridge.view.OutputView

class BridgeController {

    val resultUp = StringBuilder()
    val resultDown = StringBuilder()

    fun run() {
        InputView().startPhrases()

        val size = PrintException().printSize().toInt()

        var bridge = PrintException().printBridge(size)
        println(bridge)
        println()

        choiceBridge(bridge)
    }


    fun choiceBridge( bridge: List<String>) {

        for (i in 0 until 3){
            OutputView().printMap(bridge)
        }

    }





}