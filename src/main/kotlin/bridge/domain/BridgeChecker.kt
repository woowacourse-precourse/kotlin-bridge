package bridge.domain

import bridge.ui.InputView
import bridge.ui.OutputView
import bridge.utils.GAME_CMD_INPUT_MSG
import bridge.utils.MOVE_INPUT_MSG
import bridge.utils.RESTART

class BridgeChecker(private val bridge: List<String>) {
    private val bridgeGame = BridgeGame()
    private val outputView = OutputView()
    private var map = listOf<String>()

    fun startChecking() {
        if (checkBridge())
            outputView.printResult(map, SUCCESS, bridgeGame.getTryNumber())
        else
            restartOrQuit()
    }

    private fun checkBridge(): Boolean {
        for ((index, actual) in bridge.withIndex()) {
            if (!isCrossable(index, actual)) return false
        }
        return true
    }

    private fun isCrossable(index: Int, actual: String): Boolean {
        val predict = askDirection()
        map = outputView.printMap(index, actual, predict)
        println(map[0])
        println(map[1])
        return bridgeGame.move(actual, predict)
    }

    private fun askDirection(): String {
        println(MOVE_INPUT_MSG)
        return InputView().readMoving()
    }

    private fun restartOrQuit() {
        if (askGameCommand() == RESTART) {
            outputView.initMap()
            bridgeGame.retry()
            startChecking()
        } else {
            outputView.printResult(map, FAIL, bridgeGame.getTryNumber())
        }
    }

    private fun askGameCommand(): String {
        println(GAME_CMD_INPUT_MSG)
        return InputView().readGameCommand()
    }

    companion object {
        const val SUCCESS = "성공"
        const val FAIL = "실패"
    }
}