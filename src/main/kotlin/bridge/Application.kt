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

    bridgeManager.printSuccess()
}

fun main() {
    try {
        gameManager()
    } catch (e: IllegalArgumentException) {
        println(e.message)
        return
    }
}
