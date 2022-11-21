package bridge

fun main() {
    try {
        val gameManager = GameManager()
        gameManager.play()
    } catch (e: IllegalArgumentException) {
        println(e.message)
        return
    }
}
