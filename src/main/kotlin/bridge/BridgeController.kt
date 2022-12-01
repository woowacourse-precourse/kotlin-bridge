package bridge

import util.Constant
import util.Result
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
            endGame(Result.SUCCESS.korean)
            return
        }

        checkFail()
    }

    private fun moveNext() {
        outputView.printInputMove()
        bridgeGame.move(inputView.readMoving())
        outputView.printMap(bridgeGame.getMap())
    }

    private fun endGame(result: String) {
        outputView.printEndGame()
        outputView.printMap(bridgeGame.getMap())
        outputView.printResult(bridgeGame.getRetryCount(), result)
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
            Constant.QUIT -> {
                bridgeGame.retry()
                startGame()
            }

            Constant.RESTART -> endGame(Result.FAILURE.korean)
        }
    }
}