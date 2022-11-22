package bridge

fun main() {
    try{
        val game = BridgeGameStarter()
        game.setGame()
        game.startGame()
    } catch (e: IllegalArgumentException){
        println("[ERROR]")
    }

}