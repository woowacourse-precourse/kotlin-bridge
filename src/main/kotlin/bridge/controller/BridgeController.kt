package bridge.controller

import bridge.*
import bridge.exception.CheckException
import bridge.exception.PrintException
import bridge.view.InputView
import bridge.view.OutputView

class BridgeController {



    fun run() {
        InputView().startPhrases()

        val size = PrintException().printSize().toInt()

        var bridge = PrintException().printBridge(size)
        println(bridge)
        println()

        choiceBridge(bridge)
    }


    fun choiceBridge( bridge: List<String>) {


        OutputView().printMap(bridge)



    }





}