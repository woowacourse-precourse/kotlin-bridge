package bridge.controller

import bridge.*
import bridge.view.InputView
import bridge.view.OutputView

var count: Int = 1
class BridgeGameProgress {
    private val outputView = OutputView()

    fun bridgeGameProgress(bridge: List<String>) {
        val result = bridgeGameStart(bridge)
        if (result[result.size - 1][1] == FAIL) {
            count += 1
            return gameCommand(result, bridge)
        }
        return outputView.printResult(result, SUCCESS, count)
    }

    private fun bridgeGameStart(bridge: List<String>): MutableList<List<String>> {
        val result: MutableList<List<String>> = mutableListOf()
        selectUpDown(bridge, result)
        return result
    }

    private fun gameCommand(result: MutableList<List<String>>, bridge: List<String>) {
        OutputView().printRetry()
        val gameCommand = InputView().readGameCommand()
        if (gameCommand == QUIT) {
            return outputView.printResult(result, LOSE, count)
        }
        if (gameCommand == RETRY) {
            return BridgeGame().retry(bridge)
        }
    }

    private fun selectUpDown(bridge: List<String>, result: MutableList<List<String>>) {
        for (step in bridge) {
            OutputView().printSelectMove()
            val moving = InputView().readMoving()
            if (!BridgeGame().move(step, moving, result)) {
                outputView.printMap(result)
                break
            }
            outputView.printMap(result)
        }
    }
}