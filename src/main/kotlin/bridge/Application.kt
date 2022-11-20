package bridge

fun main() {
    try {
        GameMng().gameLoop()
    } catch (e: IllegalArgumentException) {
        print("[ERROR] ${e.message}")
    }
}
