package bridge

import bridge.domain.BridgeGame
import bridge.domain.BridgeMaker
import bridge.domain.BridgeRandomNumberGenerator
import bridge.ui.InputView
import bridge.utils.*

fun main() {
    println(GAME_START_MSG)
    val inputView = InputView()
    println(SIZE_INPUT_MSG)
    val bridgeSize = inputView.readBridgeSize()
    val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
    val bridge = bridgeMaker.makeBridge(bridgeSize)

    println(MOVE_INPUT_MSG)
    val direction = inputView.readMoving()

//    val bridgeGame = BridgeGame()
//    bridgeGame.move(direction)

}
