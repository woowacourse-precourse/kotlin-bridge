package bridge

class Controller {
    private lateinit var bridgeGame: BridgeGame
    private val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
    private val inputView = InputView()
    private val outputView = OutputView()
    private val inputInvalidCheck = InputInvalidCheck()
    private val inputConverter = InputConverter()

    fun run() {
        outputView.gameStartMessage()
        inputGameBridgeSizeStep()
        gameProgressStep()
        endGame()
    }

    private fun inputGameBridgeSizeStep() {
        val bridgeSize = inputView.readBridgeSize(outputView, inputInvalidCheck, inputConverter)
        bridgeGame = BridgeGame(bridgeMaker.makeBridge(bridgeSize))
    }

    private fun gameProgressStep() {
        while (true) {
            if(inputMoveStep()){
                continue
            }
            break
        }
    }

    private fun inputMoveStep(): Boolean { // 이동 입력 그만 받고 종료하고 싶으면 false를 반환해야 함.
        val curMoveResult = bridgeGame.move(inputView.readMoving(outputView,inputInvalidCheck))
        outputView.printMap(bridgeGame.realBridges(), bridgeGame.gameBridges(), bridgeGame.curStep)
        return moveResultStep(curMoveResult)
    }

    private fun moveResultStep(curMoveResult: BridgeGame.BridgeMoveResult): Boolean { // 이동 입력 그만 받고 싶으면 false 리턴.
        return when (curMoveResult) {
            BridgeGame.BridgeMoveResult.MOVE_FAILED -> retryStep()
            BridgeGame.BridgeMoveResult.MOVE_SUCCESS -> true
            BridgeGame.BridgeMoveResult.MOVE_END -> false
        }
    }

    private fun retryStep(): Boolean {
        if (inputView.readGameCommand(outputView,inputInvalidCheck) == "R") {
            bridgeGame.retry()
            return true
        }
        return false
    }

    private fun endGame() {
        outputView.finalGameResult()
        outputView.printMap(bridgeGame.realBridges(), bridgeGame.gameBridges(), bridgeGame.curStep)
        outputView.printResult(bridgeGame.isSuccess, bridgeGame.tryCount)
    }

}