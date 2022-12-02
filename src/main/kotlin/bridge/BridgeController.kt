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
        outputView.printStart()
        val bridgeRandomNumberGenerator = BridgeRandomNumberGenerator()
        val bridgeMaker = BridgeMaker(bridgeRandomNumberGenerator)
        val bridges = bridgeMaker.makeBridge(inputView.readBridgeSize())
        bridgeGame = BridgeGame(bridges)
    }

    private fun startGame() {
        moving()
        if (bridgeGame.isEnd()) endGame(Result.SUCCESS.korean)
        else if (bridgeGame.isFail()) checkGameFail()
        else startGame()
    }

    private fun moving() {
        outputView.printMove()
        bridgeGame.move(inputView.readMoving())
        outputView.printMap(bridgeGame.getMap())
    }

    private fun endGame(result: String) {
        outputView.printResult(bridgeGame.getMap(), result, bridgeGame.getRetryCount())
    }

    private fun checkGameFail() {
        outputView.printRestart()
        when (inputView.readGameCommand()) {
            Constant.QUIT -> endGame(Result.FAILURE.korean)

            Constant.RESTART -> restartGame()
        }
    }

    private fun restartGame() {
        bridgeGame.retry()
        startGame()
    }
}