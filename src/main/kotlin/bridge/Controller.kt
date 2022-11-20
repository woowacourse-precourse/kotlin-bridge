package bridge

import java.lang.IllegalArgumentException

class Controller() {
    private lateinit var bridgeGame: BridgeGame
    private val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
    private val inputView = InputView()
    private val outputView = OutputView()
    private val inputInvalidCheck = InputInvalidCheck()
    private val inputConverter = InputConverter()

    fun run() {
        outputView.gameStartMessage()
        inputGameBridgeSizeStep()
        while (inputMoveStep()) {
        }
        endGame()
    }

    private fun inputGameBridgeSizeStep() {
        while (true) {
            try {
                outputView.bridgeLengthInputPleaseMessage()
                val bridgeSize = inputView.readBridgeSize(inputInvalidCheck, inputConverter)
                bridgeGame = BridgeGame(bridgeMaker.makeBridge(bridgeSize))
                break
            } catch (e: IllegalArgumentException) {
                OutputView.errorMessage() // 다리 개수 입력 시 에러 처리
            }
        }
    }

    private fun inputMoveStep(): Boolean { // 이동 입력 그만 받고 종료하고 싶으면 false를 반환해야 함.
        var curMoveResult: BridgeGame.BridgeMoveResult
        try {
            outputView.moveInputPleaseMessage()
            curMoveResult = bridgeGame.move(inputView.readMoving(inputInvalidCheck))
            outputView.printMap(bridgeGame.realBridges(), bridgeGame.gameBridges(), bridgeGame.curStep())
        } catch (e: IllegalArgumentException) {
            OutputView.errorMessage() // 이동 입력 시 에러 처리
            return true
        }
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
            } catch (e: IllegalArgumentException) {
                OutputView.errorMessage()
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
        outputView.printMap(bridgeGame.realBridges(),
            bridgeGame.gameBridges(),
            bridgeGame.curStep())
        outputView.printResult(bridgeGame.isGameSuccess(), bridgeGame.tryCount())
    }

}