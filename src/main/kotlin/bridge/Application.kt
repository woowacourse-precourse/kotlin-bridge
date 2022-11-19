package bridge

fun gameManager() {
    val inputView = InputView()
    val outputView = OutputView()
    val bridgeManager = BridgeManager(inputView, outputView)

    while (bridgeManager.getBridgeGame().isContinue && bridgeManager.getPosition() < bridgeManager.getBridgeSize()) {
        bridgeManager.moveBridge()
        if (bridgeManager.failChecker()) {
            return
        }
    }

    val triple = Triple(bridgeManager.getPosition()-1, bridgeManager.getBridgeGame().getUpBridge(), bridgeManager.getBridgeGame().getDownBridge())
    outputView.printResult(triple, true)
    outputView.printTryNumber(bridgeManager.getBridgeGame().getRetryCounter())
}

fun main() {
    try {
        gameManager()
    } catch (e: IllegalArgumentException) {
        println(e.message)
        return
    }
}
