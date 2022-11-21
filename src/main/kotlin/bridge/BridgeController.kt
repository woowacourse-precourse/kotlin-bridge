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
        startMove()
    }

    private fun makeBridge() {
        outputView.printStartGame()
        val bridgeRandomNumberGenerator = BridgeRandomNumberGenerator()
        val bridgeMaker = BridgeMaker(bridgeRandomNumberGenerator)
        val bridges = bridgeMaker.makeBridge(inputView.readBridgeSize())
        bridgeGame = BridgeGame(bridges)
    }

    private fun startMove() {
        moveNext()
        if (bridgeGame.isEnd()) {
            printEndMove(Enum.RESULT.SUCCESS.korean)
            return
        }
        if (isFail())
            return
        startMove()
    }

    private fun moveNext() {
        outputView.printInputMove()
        bridgeGame.move(inputView.readMoving())
        outputView.printMap(bridgeGame.getUpSide(), bridgeGame.getDownSide())
    }

    private fun printEndMove(result: String) {
        outputView.printEndGame()
        outputView.printMap(bridgeGame.getUpSide(), bridgeGame.getDownSide())
        outputView.printResult(bridgeGame.getTryCount(), result)
    }

    private fun isFail(): Boolean {
        if (bridgeGame.isFail(Enum.RESULT.FAILURE.emoji)) {
            outputView.printRestart()
            return isRestart()
        }
        return false
    }

    private fun isRestart(): Boolean {
        when (inputView.readGameCommand()) {
            Enum.OPTION.RESTART.command -> bridgeGame.retry()
            Enum.OPTION.QUIT.command -> {
                printEndMove(Enum.RESULT.FAILURE.korean)
                return true
            }
        }
        return false
    }
}