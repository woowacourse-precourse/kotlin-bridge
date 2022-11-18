package bridge

import bridge.constants.*

fun main() {
    var count = 0
    OutputView().printMessage(START_MESSAGE)
    OutputView().printMessage(BRIDGE_SIZE_MESSAGE)
    val size = InputView().readBridgeSize()
    val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(size)
    println(bridge)

    val userStep = mutableListOf<Boolean>()
    do {
        count++
        var stop = false
        userStep.clear()
        for (index in bridge) {
            OutputView().printMessage(MOVE_MESSAGE)
            val moveDirection = InputView().readMoving()
            val successOrFail = BridgeGame().move(index, moveDirection)
            userStep.add(successOrFail)
            OutputView().printMap(bridge, userStep)

            if (!successOrFail) {
                OutputView().printMessage(RETRY_MESSAGE)
                val command = InputView().readGameCommand()
                stop = BridgeGame().retry(command)
                break
            }
        }
    } while (stop)

    OutputView().printResult(bridge, userStep, count)
}
