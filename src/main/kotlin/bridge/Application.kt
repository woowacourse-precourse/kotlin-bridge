package bridge

import bridge.domain.BridgeGame

fun main() {
    val userPlayer = Player(BridgeGame())
    userPlayer.startGame()
}
