package bridge

import java.lang.Exception

fun main() {
    val game = BridgeGame()

    game.apply {
        kotlin.runCatching {
            game.start()
            do{
                game.move()
            }
            while (game.retry())
            game.end()
        }
            .onFailure {
                println("[ERROR]")
                return
            }
    }

}
