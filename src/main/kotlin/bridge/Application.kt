package bridge

fun gameManager() {
    val inputView = InputView()
    val outputView = OutputView()
    val bridgeManager = BridgeManager(inputView, outputView)

    if(bridgeManager.gameLoop()) {
        bridgeManager.printSuccess()
    }
}

fun main() {
    try {
        gameManager()
    } catch (e: IllegalArgumentException) {
        println(e.message)
        return
    }
}
