package bridge.domain

import bridge.view.InputView
import bridge.view.OutputView
import bridge.view.OutputView.Companion.RESULT_FAIL
import bridge.view.OutputView.Companion.RESULT_SUCCESS

class BridgeGameManager(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun startGame() {
        outputView.printStart()
    }

    fun endGame(map: List<List<String>>, isGameSuccess: Boolean, numOfTry: Int) {
        val result = when {
            isGameSuccess -> RESULT_SUCCESS
            else -> RESULT_FAIL
        }
        outputView.printResult(map, result, numOfTry)
    }

    fun getBridgeSize(): Int {
        while (true) {
            try {
                return inputView.readBridgeSize()
            } catch (e: IllegalArgumentException) {
                println(e.message)
                continue
            }
        }
    }

    fun getMovement(): String {
        while (true) {
            try {
                return inputView.readMoving()
            } catch (e: IllegalArgumentException) {
                println(e.message)
                continue
            }
        }
    }

    fun getRestartCommand(): String {
        while (true) {
            try {
                return inputView.readGameCommand()
            } catch (e: IllegalArgumentException) {
                println(e.message)
                continue
            }
        }
    }

    fun printMap(map: List<List<String>>) {
        outputView.printMap(map)
    }
}