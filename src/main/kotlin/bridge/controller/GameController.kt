package bridge.controller

import bridge.*
import bridge.model.BridgeGame
import bridge.view.InputView
import bridge.view.OutputView

class GameController {

    private val bridgeGame = BridgeGame()
    private var size = ZERO
    private var isPlaying = true
    private var position = ZERO
    private var tryCount = 1

    init {
        OutputView.startGame()
        getBridgeLength()
        println()
        bridgeGame.makeBridge(size)
        bridgeGame.initMatrix(size)
    }

    fun start() {
        while (isPlaying) {
            val direction = getMoveDirection()
            val isSuccess = bridgeGame.compare(direction, position)
            bridgeGame.move(direction, position)
            OutputView.printMap(bridgeGame.progressMatrix.progress, position)
            completeOrFail(isSuccess)
        }
    }

    private fun getBridgeLength() {
        while (true) {
            try {
                OutputView.inputLength()
                size = InputView.readBridgeSize()
                break
            } catch (e: Exception) {
                println("$ERROR ${e.message}\n")
            }
        }
    }

    private fun getMoveDirection(): String {
        while (true) {
            try {
                OutputView.selectMove()
                return InputView.readMoving()
            } catch (e: Exception) {
                println("$ERROR ${e.message}\n")
            }
        }
    }

    private fun completeOrFail(isSuccess: Boolean) {
        if (isSuccess) {
            if (position == size - 1) {
                OutputView.finalResult()
                OutputView.printResult(bridgeGame.progressMatrix.progress, position)
                OutputView.isSuccess(SUCCESS)
                OutputView.totalTryCount(tryCount)
                isPlaying = false
            }
        }
    }
}