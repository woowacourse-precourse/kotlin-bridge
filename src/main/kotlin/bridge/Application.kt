package bridge

import bridge.view.InputValidator
import bridge.view.InputView
import bridge.view.OutputView

fun main() {
    val gameController = GameController(InputView(InputValidator()), OutputView())
    gameController.standByPhase(BridgeMaker(BridgeRandomNumberGenerator()))
    gameController.mainPhase()
    gameController.endPhase()
}
