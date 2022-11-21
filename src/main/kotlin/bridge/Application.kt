package bridge

import bridge.controller.Processor
import bridge.model.BridgeGame
import bridge.model.BridgeMaker
import bridge.util.InputValidator
import bridge.view.InputView
import bridge.view.OutputView

//processGame 위치 바꾸자


fun main() {
    val processor = Processor(
        BridgeGame(BridgeMaker(BridgeRandomNumberGenerator())),
        InputView(InputValidator()),
        OutputView())

    processor.processGame()
}


