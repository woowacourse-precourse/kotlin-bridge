package bridge

import bridge.constants.*

fun main() {
    OutputView().printMessage(START_MESSAGE, BRIDGE_SIZE_MESSAGE)
    val size = InputView().readBridgeSize()
    val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(size)
    val userStep = mutableListOf<Boolean>()
    val count = game(bridge, userStep)

    val printValue = BridgeGame().determineMap(bridge, userStep)
    OutputView().printResult(printValue, userStep, count)
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
        val answer = checkAnswer(index, userStep, bridge)
        if (!answer)
            return fail()
    }
    return false
}

fun checkAnswer(index: String, userStep: MutableList<Boolean>, bridge: List<String>): Boolean {
    val successOrFail = BridgeGame().move(index, InputView().readMoving())
    userStep.add(successOrFail)
    OutputView().printMap(BridgeGame().determineMap(bridge, userStep))
    return successOrFail
}

fun fail(): Boolean {
    OutputView().printMessage(RETRY_MESSAGE)
    val command = InputView().readGameCommand()
    return BridgeGame().retry(command)
}
