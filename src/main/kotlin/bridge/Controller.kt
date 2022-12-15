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
        while (true) {
            try {
                outputView.bridgeLengthInputPleaseMessage()
                val bridgeSize = inputView.readBridgeSize(inputInvalidCheck, inputConverter)
                bridgeGame = BridgeGame(bridgeMaker.makeBridge(bridgeSize))
                break
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }

    private fun gameProgressStep() {
        while (true) {
            try {
                val isStopGame = inputMoveStep()
                if (!isStopGame) break  // 게임을 재시작을 안하거나 게임 완료한 경우.
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }

    private fun inputMoveStep(): Boolean { // 이동 입력 그만 받고 종료하고 싶으면 false를 반환해야 함.
        outputView.moveInputPleaseMessage()
        val curMoveResult = bridgeGame.move(inputView.readMoving(inputInvalidCheck))
        outputView.printMap(bridgeGame.realBridges(), bridgeGame.gameBridges(), bridgeGame.curStep)
        return moveResultStep(curMoveResult)
    }

    private fun moveResultStep(curMoveResult: BridgeGame.BridgeMoveResult): Boolean { // 이동 입력 그만 받고 싶으면 false 리턴.
        return when (curMoveResult) {
            BridgeGame.BridgeMoveResult.MOVE_FAILED -> moveFailedStep()
            BridgeGame.BridgeMoveResult.MOVE_SUCCESS -> true
            else -> false
        }
    }

    private fun moveFailedStep(): Boolean {
        while (true) {
            try {
                return inputRetryStep()
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }

    private fun inputRetryStep(): Boolean {
        outputView.retryInputPleaseMessage()
        if (inputView.readGameCommand(inputInvalidCheck) == "R") {
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