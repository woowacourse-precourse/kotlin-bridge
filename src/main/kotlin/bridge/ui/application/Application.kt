package bridge.ui.application

import bridge.domain.game.BridgeGame
import bridge.domain.generator.BridgeRandomNumberGenerator
import bridge.domain.maker.BridgeMaker
import bridge.ui.view.InputView
import bridge.ui.view.OutputView

fun main() {
    // TODO: 프로그램 구현
    val inputView = InputView()
    val outputView = OutputView()
    val bridgeNumberGenerator = BridgeRandomNumberGenerator()
    val bridgeMaker = BridgeMaker(bridgeNumberGenerator = bridgeNumberGenerator)
    val bridgeGame = BridgeGame(inputView = inputView, outputView = outputView, bridgeMaker = bridgeMaker)

    bridgeGame.play()
}
