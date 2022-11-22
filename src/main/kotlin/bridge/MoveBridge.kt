package bridge

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
        BridgeResult().finalResult("성공")
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
            BridgeResult().finalResult("실패")
        }
    }
}