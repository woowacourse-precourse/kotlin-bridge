package bridge

fun main() {
    try {
        val bridgeManager = BridgeManager()
        bridgeManager.start()
    } catch (e: IllegalArgumentException) {
        println(e.message)
        return
    }
}
