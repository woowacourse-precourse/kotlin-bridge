package bridge.ui.application

import bridge.domain.game.BridgeGame
import bridge.domain.generator.BridgeRandomNumberGenerator
import bridge.domain.maker.BridgeMaker
import bridge.domain.mediator.BridgeGameViewMediator
import bridge.ui.view.InputView
import bridge.ui.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val bridgeGameViewMediator = BridgeGameViewMediator(inputView = inputView, outputView = outputView)

    val bridgeNumberGenerator = BridgeRandomNumberGenerator()
    val bridgeMaker = BridgeMaker(bridgeNumberGenerator = bridgeNumberGenerator)

    val bridgeGame = BridgeGame(bridgeGameViewMediator = bridgeGameViewMediator, bridgeMaker = bridgeMaker)

    bridgeGame.play()
}
