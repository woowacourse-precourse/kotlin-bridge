package bridge

import bridge.View.InputView
import bridge.utils.Messages

fun main() {
//     TODO: 프로그램 구현
    println(Messages.GameStart)
    val size = InputView().readBridgeSize()
    print(BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(size))

}
