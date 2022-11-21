package bridge.console

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import bridge.model.Bridge
import bridge.model.BridgeGame
import bridge.view.OutputView

class BridgeGameConsole {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val bridgeGame = BridgeGame()
    private lateinit var bridge: Bridge


    fun startGame(){
        outputView.printGameInitializeProcess()
        bridge = Bridge(BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(inputView.readBridgeSize()))
        processMovingPart(bridge)
    }

    fun processMovingPart(bridge: Bridge){
        do {
            outputView.printGameInputMoveLaneMessage()
            bridgeGame.move(inputView.readMoving(), bridge)
            outputView.printMap(bridgeGame.upLane, bridgeGame.downLane)
        }while(bridgeGame.isMovingSuccess && !bridge.isFinished())
        decideGamePart()
    }

    fun decideGamePart(){
        if (!bridgeGame.isMovingSuccess)
            processGameCommandPart()
        if (bridge.isFinished())
            outputView.printResult()
    }

    fun processGameCommandPart(){
        outputView.printGameInputGameCommandMessage()
        when (inputView.readGameCommand()){
            'R' -> {
                setForRetrial()
                processMovingPart(bridge)
            }
            'Q' -> outputView.printResult()
        }
    }

    fun setForRetrial(){
        bridge.initializeLaneCount()
        bridgeGame.retry()
    }
}


fun main(){
    BridgeGameConsole().startGame()
}