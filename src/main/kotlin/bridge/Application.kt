package bridge

fun main() {
    try{
        val game = BridgeGameStarter()
        game.setGame()
    } catch (e: IllegalArgumentException){
        println("[ERROR]")
    }

}