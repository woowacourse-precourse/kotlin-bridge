package bridge.console

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import bridge.model.Bridge
import bridge.model.BridgeGame
import bridge.model.GameInfo
import bridge.utils.Constants
import bridge.view.OutputView

class BridgeGameConsole {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val bridgeGame = BridgeGame()
    private lateinit var bridge: Bridge

    /**
     * 처음 입력 받는 부분 진행
     */
    fun startGame(){
        outputView.printGameInitializeProcess()
        bridge = Bridge(BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(inputView.readBridgeSize()))
        processMovingPart()
    }

    /**
     * 움직일 칸을 입력받고 이동하는 부분 진행
     */
    fun processMovingPart(){
        GameInfo.GAME_TRIAL_COUNT.gameTrialCount += 1
        do {
            outputView.printGameInputMoveLaneMessage()
            bridgeGame.move(inputView.readMoving(), bridge)
            outputView.printMap(bridgeGame.upLane, bridgeGame.downLane)
        }while(bridgeGame.isMovingSuccess && !bridge.isMoveUntilEnd())
        decideGamePart()
    }

    /**
     * 결과를 출력할지 재시도 문구를 띄울지 결정하는 함수
     */
    fun decideGamePart(){
        when(bridgeGame.isMovingSuccess) {
            true -> outputView.printResult(bridgeGame.upLane, bridgeGame.downLane, true)
            false -> processGameCommandPart()
        }
    }

    /**
     * 재시도 입력 문자에 따라 결과를 출력할지 다시 게임을 진행할지 결정하는 함수
     */
    fun processGameCommandPart(){
        outputView.printGameInputGameCommandMessage()
        when (inputView.readGameCommand()){
            "R" -> {
                setForRetrial()
                processMovingPart()
            }
            "Q" -> outputView.printResult(bridgeGame.upLane, bridgeGame.downLane, false)
        }
    }

    /**
     * 재시작을 위한 초기화 함수
     */
    fun setForRetrial(){
        bridge.initializeLaneCount()
        bridgeGame.retry()
    }
}


