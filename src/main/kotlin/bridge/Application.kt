package bridge

import bridge.domain.BridgeMaker
import bridge.domain.BridgeRandomNumberGenerator
import bridge.ui.InputView
import bridge.utils.*

fun main() {
    try {
        println(GAME_START_MSG)

        val inputView = InputView()
        println(SIZE_INPUT_MSG)
        val bridgeSize = inputView.readBridgeSize()

        val generator = BridgeRandomNumberGenerator()
        val bridgeMaker = BridgeMaker(generator)
        val bridge = bridgeMaker.makeBridge(bridgeSize)

        println(bridge)
    }catch (e: IllegalArgumentException){
        println(e.message)
        // 에러 문구 출력 후 해당 부분부터 다시 입력을 받는다.
    }
}
