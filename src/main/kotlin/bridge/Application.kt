package bridge

fun main() {
    try{
        val game = BridgeGameStarter()
        game.setGame()
        game.startGame()
    } catch(e: IllegalArgumentException){
        println("[ERROR] 오류가 발생했습니다.")
    }
}