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
        move()
        if (bridgeGame.isEnd()) {
            end(Enum.RESULT.SUCCESS.korean)
            return
        }
        if (fail())
            return
        startGame()
    }

    private fun move() {
        outputView.printInputMove()
        bridgeGame.move(inputView.readMoving())
        outputView.printMap(bridgeGame.getUpSide(), bridgeGame.getDownSide())
    }

    private fun end(result: String) {
        outputView.printEndGame()
        outputView.printMap(bridgeGame.getUpSide(), bridgeGame.getDownSide())
        outputView.printResult(bridgeGame.getTryCount(), result)
    }

    private fun fail(): Boolean {
        if (bridgeGame.isFail(Enum.RESULT.FAILURE.emoji)) {
            outputView.printRestart()
            return restart()
        }
        return false
    }

    private fun restart(): Boolean {
        when (inputView.readGameCommand()) {
            Enum.OPTION.RESTART.command -> bridgeGame.retry()
            Enum.OPTION.QUIT.command -> {
                end(Enum.RESULT.FAILURE.korean)
                return true
            }
        }
        return false
    }
}