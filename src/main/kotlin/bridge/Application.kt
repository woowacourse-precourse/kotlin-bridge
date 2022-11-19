package bridge

fun main() {
    try {
        val bridgeManager = BridgeManager()
        bridgeManager.gameLoop()
    } catch (e: IllegalArgumentException) {
        println(e.message)
        return
    }
}
