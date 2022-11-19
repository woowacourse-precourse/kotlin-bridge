package bridge

fun main() {
    try {
        BridgeGame().gameLoop()
    } catch (e: IllegalArgumentException) {
        print("[ERROR] ${e.message}")
    }
}
