package bridge

import util.Enum
import view.InputView
import view.OutputView

class BridgeController {
    private lateinit var bridgeGame: BridgeGame

    fun run() {
        makeBridge()
        startGame()
    }

    private fun makeBridge() {
        OutputView.printStartGame()
        val bridgeRandomNumberGenerator = BridgeRandomNumberGenerator()
        val bridgeMaker = BridgeMaker(bridgeRandomNumberGenerator)
        val bridges = bridgeMaker.makeBridge(InputView.readBridgeSize())
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
        OutputView.printInputMove()
        bridgeGame.move(InputView.readMoving())
        OutputView.printMap(bridgeGame.getUpSide(), bridgeGame.getDownSide())
    }

    private fun end(result: String) {
        OutputView.printEndGame()
        OutputView.printMap(bridgeGame.getUpSide(), bridgeGame.getDownSide())
        OutputView.printResult(bridgeGame.getTryCount(), result)
    }

    private fun fail(): Boolean {
        if (bridgeGame.isFail(Enum.RESULT.FAILURE.emoji)) {
            OutputView.printRestart()
            return restart()
        }
        return false
    }

    private fun restart(): Boolean {
        when (InputView.readGameCommand()) {
            Enum.OPTION.RESTART.command -> bridgeGame.retry()
            Enum.OPTION.QUIT.command -> {
                end(Enum.RESULT.FAILURE.korean)
                return true
            }
        }
        return false
    }
}