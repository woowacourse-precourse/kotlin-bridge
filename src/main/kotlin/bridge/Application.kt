package bridge

fun gameManager() {
    val inputView = InputView()
    val outputView = OutputView()
    val bridgeManager = BridgeManager(inputView, outputView)

    bridgeManager.gameLoop()
}

fun main() {
    try {
        gameManager()
    } catch (e: IllegalArgumentException) {
        println(e.message)
        return
    }
}
