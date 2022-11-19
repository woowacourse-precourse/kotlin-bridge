package bridge

fun gameManager() {
    val inputView = InputView()
    val outputView = OutputView()
    val bridgeManager = BridgeManager(inputView, outputView)

    var position = 0
    while (bridgeManager.getBridgeGame().isContinue && position < bridgeManager.getBridgeSize()) {
        bridgeManager.moveBridge(position)
        position++

        // 중간에 실패한 경우
        if (!bridgeManager.getBridgeGame().isContinue && position < bridgeManager.getBridgeSize()) {
            outputView.printRetry()
            val retryCommand = inputView.readGameCommand()
            if (retryCommand == "R") {
                bridgeManager.getBridgeGame().retry()
                position = 0
            } else {
                val triple = Triple(position, bridgeManager.getBridgeGame().getUpBridge(), bridgeManager.getBridgeGame().getDownBridge())
                outputView.printResult(triple, false)
                outputView.printTryNumber(bridgeManager.getBridgeGame().getRetryCounter())
                return
            }
        }
    }

    val triple = Triple(position-1, bridgeManager.getBridgeGame().getUpBridge(), bridgeManager.getBridgeGame().getDownBridge())
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
