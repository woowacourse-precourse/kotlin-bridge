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
        val bridgeGame = BridgeGame(bridge)

        choiceBridge(bridgeGame)
        OutputView().printResult(bridgeGame)
    }

    fun choiceBridge(bridgeGame: BridgeGame){
        var fact = true
        while (fact){
            var direction = PrintException().printDirection()
            bridgeGame.move(direction)
            OutputView().printMap(bridgeGame)
            println()

            if(bridgeGame.choiceFail()!!){  fact = restartGame(bridgeGame)!!}
            if (!bridgeGame.choiceFail() && bridgeGame.choiceAll()){  fact = false }
        }
    }


    fun restartGame(bridgeGame: BridgeGame) :Boolean?{
        val restart = PrintException().printRestart()
        println()
        if(restart == "R"){
            bridgeGame.retry()
            return true
        }
        if (restart == "Q"){
            return false
        }
        return null
    }






}