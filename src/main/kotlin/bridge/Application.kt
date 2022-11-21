package bridge

import bridge.View.InputView
import bridge.View.OutputView
import bridge.computer.BridgeMaker
import bridge.computer.BridgeRandomNumberGenerator
import bridge.computer.ErrorMessage
import bridge.utils.Messages

    public var bridge = mutableListOf<String>()
    public var location : Int = -1
    public var gameCount : Int = 1
    public var isGameClear = false

fun main() {
//     TODO: 프로그램 구현
    try {

    println(Messages.GameStart)

    BridgeGame().initState()
    BridgeGame().start()

    while (!isGameClear) {
        BridgeGame().move()
        BridgeGame().calculate()
        OutputView().printMap()
    }

    BridgeGame().end()
    } catch (_: IllegalArgumentException) {
        println(ErrorMessage.OCCUR.messages)
    }
}
