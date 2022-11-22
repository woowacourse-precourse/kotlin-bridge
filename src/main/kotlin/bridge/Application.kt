package bridge

fun main() {
    try {
        val game = BridgeGame()
        game.gameStart()
    }
    catch(error:Exception){
        println(error.message)
    }
}
