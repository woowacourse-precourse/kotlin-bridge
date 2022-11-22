package bridge

import bridge.utils.Print
import bridge.view.OutputView

class BridgeResult {
    fun finalResult(result: String) {
        Print.showGameResult()
        OutputView().printResult(BridgeGame().getBridgeMap())
        Print.showIsSuccess(result)
        Print.showAttempt(BridgeGame().getGameCount())
    }
}