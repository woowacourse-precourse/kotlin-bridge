package bridge

fun main() {
    try{
        val game = Game()
        game.gameStart()
    } catch (e : IllegalArgumentException){
        println(e.message)
    }
}
