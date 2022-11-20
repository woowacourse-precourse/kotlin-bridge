package bridge

fun main() {
    val game = BridgeGame()

    game.start()
    do{
        game.move()
    }
    while (game.retry())
    game.end()
}
