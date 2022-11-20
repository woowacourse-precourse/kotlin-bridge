package bridge

import bridge.constants.*

fun main() {
    OutputView().printMessage(START_MESSAGE, BRIDGE_SIZE_MESSAGE)
    val size = InputView().readBridgeSize()
    val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(size)

    val userStep = mutableListOf<Boolean>()
    val count = game(bridge, userStep)

    OutputView().printResult(bridge, userStep, count)
}

fun game(bridge: List<String>, userStep: MutableList<Boolean>): Int {
    var count = 0
    do {
        count++
        userStep.clear()
        val stop = move(bridge, userStep)
    } while (stop)
    return count
}

fun move(bridge: List<String>, userStep: MutableList<Boolean>): Boolean {
    for (index in bridge) {
        OutputView().printMessage(MOVE_MESSAGE)
        val moveDirection = InputView().readMoving()
        val successOrFail = BridgeGame().move(index, moveDirection)
        userStep.add(successOrFail)
        OutputView().printMap(bridge, userStep)
        if (!successOrFail)
            return fail()
    }
    return false
}

fun fail(): Boolean {
    OutputView().printMessage(RETRY_MESSAGE)
    val command = InputView().readGameCommand()
    return BridgeGame().retry(command)
}
