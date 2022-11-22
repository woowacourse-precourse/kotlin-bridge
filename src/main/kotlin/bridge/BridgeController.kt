package bridge

import util.Enum
import view.InputView
import view.OutputView

class BridgeController {
    private lateinit var bridgeGame: BridgeGame
    private val outputView = OutputView()
    private val inputView = InputView()

    fun run() {
        makeBridge()
        startGame()
    }

    private fun makeBridge() {
        outputView.printStartGame()
        val bridgeRandomNumberGenerator = BridgeRandomNumberGenerator()
        val bridgeMaker = BridgeMaker(bridgeRandomNumberGenerator)
        val bridges = bridgeMaker.makeBridge(inputView.readBridgeSize())
        bridgeGame = BridgeGame(bridges)
    }

    private fun startGame() {
        moveNext()
        if (bridgeGame.isEnd()) {
            endGame(Enum.RESULT.SUCCESS.korean)
            return
        }

        checkFail()
    }

    private fun moveNext() {
        outputView.printInputMove()
        bridgeGame.move(inputView.readMoving())
        outputView.printMap(bridgeGame.getUpSide(), bridgeGame.getDownSide())
    }

    private fun endGame(result: String) {
        outputView.printEndGame()
        outputView.printMap(bridgeGame.getUpSide(), bridgeGame.getDownSide())
        outputView.printResult(bridgeGame.getTryCount(), result)
    }

    private fun checkFail() {
        if (bridgeGame.isFail()) {
            outputView.printRestart()
            isRestart()
        } else {
            startGame()
        }
    }

    private fun isRestart() {
        when (inputView.readGameCommand()) {
            QUIT -> {
                bridgeGame.retry()
                startGame()
            }

            RESTART -> endGame(Enum.RESULT.FAILURE.korean)
        }
    }

    companion object {
        const val RESTART = "R"
        const val QUIT = "Q"
    }
}