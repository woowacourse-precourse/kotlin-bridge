package bridge.controller

import bridge.ERROR
import bridge.ZERO
import bridge.model.BridgeGame
import bridge.view.InputView
import bridge.view.OutputView

class GameController {

    private val bridgeGame = BridgeGame()
    private var size = ZERO
    private var isPlaying = true
    private var position = ZERO

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
            bridgeGame.compare(direction, position)
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
}