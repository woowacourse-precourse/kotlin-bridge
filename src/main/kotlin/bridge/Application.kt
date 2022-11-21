package bridge

import bridge.View.InputView
import bridge.View.OutputView
import bridge.computer.BridgeMaker
import bridge.computer.BridgeRandomNumberGenerator
import bridge.utils.Messages

    public var bridge = mutableListOf<String>()
    public var location : Int = -1
    public var gameCount : Int = 1
    public var isGameClear = false

fun main() {
//     TODO: 프로그램 구현
    println(Messages.GameStart)

    val size = InputView().readBridgeSize()
    bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(size).toMutableList()


    BridgeGame().start()

    while (!isGameClear) {
        BridgeGame().move()
        BridgeGame().calculate()
        OutputView().printMap()
    }

    BridgeGame().end()
}
