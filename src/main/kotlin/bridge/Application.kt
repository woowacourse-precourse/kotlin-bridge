package bridge

import bridge.constants.*

fun main() {
    OutputView().printMessage(START_MESSAGE)
    OutputView().printMessage(BRIDGE_SIZE_MESSAGE)
    val size = InputView().readBridgeSize()
    val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(size)
    println(bridge)


    do {
        var stop = false
        val userStep = mutableListOf<Boolean>()
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



}
