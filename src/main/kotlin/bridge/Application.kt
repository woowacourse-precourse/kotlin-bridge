package bridge

fun main() {
    OutputView().printStartMessage()
    OutputView().printAskBridgeSize()
    val size = InputView().readBridgeSize()
    val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(size)
    println(bridge)

    val userStep = mutableListOf<Boolean>()
    for (index in bridge) {
        OutputView().printMoveMessage()
        val moveDirection = InputView().readMoving()
        val successOrFail = BridgeGame().move(index, moveDirection)
        userStep.add(successOrFail)

        OutputView().printMap(bridge, userStep)
        // if(틀렸을 경우)
    }



}
