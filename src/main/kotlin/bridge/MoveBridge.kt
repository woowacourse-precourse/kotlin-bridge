package bridge

import bridge.utils.Print
import bridge.view.InputView
import bridge.view.OutputView

class MoveBridge(private val bridge: List<String>) {
    fun moveStair() {
        for (index in bridge.indices) {
            val bridgeMap = BridgeGame().move(InputView().readMoving(), bridge[index])
            OutputView().printMap(bridgeMap)
            if (isFailure(bridgeMap)) {
                isRestart()
                return
            }
        }
        finalResult("성공")
    }

    private fun isFailure(bridgeMap: Array<MutableList<String>>): Boolean {
        with(BridgeRandomNumberGenerator) {
            if (bridgeMap[RANDOM_LOWER_INCLUSIVE].contains(BridgeGame.NOT_CORRECT_SYMBOL) ||
                bridgeMap[RANDOM_UPPER_INCLUSIVE].contains(BridgeGame.NOT_CORRECT_SYMBOL)
            ) {
                return true
            }
            return false
        }
    }

    private fun isRestart() {
        val restartCommand = InputView().readGameCommand()
        if (BridgeGame().retry(restartCommand)) {
            moveStair()
        } else {
            finalResult("실패")
        }
    }

    private fun finalResult(result: String) {
        Print.showGameResult()
        OutputView().printResult(BridgeGame().getBridgeMap())
        Print.showIsSuccess(result)
        Print.showAttempt(BridgeGame().getGameCount())
    }
}