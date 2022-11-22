package bridge

import ui.InputView
import ui.OutputView
import values.Inform
import values.Request
import values.Retry

/**
 * 다리 건너기 게임의 진행을 관리하는 클래스
 */
class BridgeGameController {
    private val inputView: InputView = InputView()
    private val outputView: OutputView = OutputView()
    private val bridgeGame: BridgeGame = BridgeGame()

    fun runGame() {
        setGame()
        startGame()
        endGame()
    }

    private fun setGame() {
        println(Inform.GAME_START.message + "\n")
        println(Request.BRIDGE_SIZE.message)
        bridgeGame.setBridgeSize(inputView.readBridgeSize())
        println()

        val bridgeRandomGenerator = BridgeRandomNumberGenerator()
        bridgeGame.setBridge(BridgeMaker(bridgeRandomGenerator).makeBridge(bridgeGame.getBridgeSize()))
    }

    private fun startGame() {
        while (isContinue()) {
            proceedTurn()
        }
    }

    private fun endGame() {
        outputView.printResult(bridgeGame)
    }

    private fun isContinue(): Boolean {
        if (bridgeGame.getBridgeSize() <= bridgeGame.getMoveCount()) return false
        if (!bridgeGame.isSuccess()) {
            println(Request.COMMAND.message)
            return if (inputView.readGameCommand() == Retry.TRY.message) {
                bridgeGame.retry()
                true
            } else false
        }
        return true
    }

    private fun proceedTurn() {
        println(Request.MOVING.message)
        bridgeGame.move(inputView.readMoving())
        outputView.printMap(bridgeGame.getGameProgress())
    }

}