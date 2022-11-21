package bridge.console

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import bridge.model.Bridge
import bridge.model.BridgeGame
import bridge.view.OutputView

class BridgeGameConsole {
    private val outputView = OutputView()
    private val bridgeGame = BridgeGame()

    fun startGame(){
        outputView.printGameInitializeProcess()
        val bridge = Bridge(BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(InputView().readBridgeSize()))
        processGame(bridge)
    }

    fun processGame(bridge: Bridge){
        do {
            outputView.printGameInputMoveLaneMessage()
            bridgeGame.move(InputView().readMoving(), bridge)
            outputView.printMap(bridgeGame.upLane, bridgeGame.downLane)
        }while(bridgeGame.isMovingSuccess)
    }
}

fun main(){
    BridgeGameConsole().startGame()
}