package bridge

import bridge.game.Bridge
import bridge.game.BridgeGame
import bridge.game.Status
import bridge.io.InputView
import bridge.io.OutputView

fun main() {
    println("다리 건너기 게임을 시작합니다.\n")
    val input = InputView()
    val maker = BridgeMaker(BridgeRandomNumberGenerator())
    val bridge = maker.makeBridge(input.readBridgeSize())
    println(bridge)
    println()
    val gameManager = BridgeGame(bridge, Bridge(mutableListOf<String>(), InputView(), OutputView()), Status())
    gameManager.play()
}
