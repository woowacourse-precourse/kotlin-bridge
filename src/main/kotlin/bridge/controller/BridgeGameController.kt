package bridge.controller

import bridge.BridgeRandomNumberGenerator
import bridge.domain.*
import bridge.sentence.InputSentence
import bridge.view.InputView
import bridge.view.OutputView

class BridgeGameController(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun play() {
        try {
            InputSentence.START.print()
            val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
            val bridge = Bridge(bridgeMaker.makeBridge(inputView.readBridgeSize()))
            val bridgeGame = BridgeGame(bridge, Player())
            var inProgress = true
            while (inProgress) {
                val moveResult = bridgeGame.move(inputView.readMoving())
                outputView.printMap(moveResult)
                if(!moveResult.last().getIsMovable()){
                    when(inputView.readGameCommand()) {
                        GameCommand.RESTART -> {
                            bridgeGame.retry()
                        }
                        GameCommand.QUIT ->
                            inProgress = false
                    }
                }
                if(bridgeGame.isCompleted())
                    inProgress = false
            }
            outputView.printResult(bridgeGame.getPlayer())
        } catch (exception: IllegalArgumentException) {
            println(exception.message)
        }
    }


}