package bridge.ui

import bridge.data.*

class OutputView {
    fun printOpening() {
        println(GAME_START + NEXT_LINE)
        println(ENTER_BRIDGE_SIZE)
    }

    fun printRequestDirection() {
        println(ENTER_DIRECTION)
    }

    fun printAskRetry() {
        println(ENTER_GAME_RETRY)
    }

    fun printMap(bridgeContainer: BridgeContainer) {
        println(bridgeContainer.getUpperBridge)
        println(bridgeContainer.getLowerBridge)
    }

    fun printResult(bridgeContainer: BridgeContainer, boolean: Boolean, coin: Int) {
        println(GAME_RESULT)
        println(bridgeContainer.getUpperBridge)
        println(bridgeContainer.getLowerBridge)
        println(NEXT_LINE+GAME_BOOLEAN + if (boolean) SUCCESS else FAIL)
        println(COUNT_RETRY + coin)
    }

    fun printErrorMessage(message: String?) {
        println(message)
    }
}
