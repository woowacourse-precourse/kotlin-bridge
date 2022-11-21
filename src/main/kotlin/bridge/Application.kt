package bridge

import bridge.View.InputView
import bridge.View.OutputView
import bridge.utils.Messages

    public var bridge = mutableListOf<String>()
    public var location : Int = -1

fun main() {
//     TODO: 프로그램 구현
    println(Messages.GameStart)

    BridgeGame().start()

    val moveDirection = InputView().readMoving()
    location = BridgeGame().move(location)
    BridgeGame().calculate(moveDirection)

    OutputView().printMap()
}
