package bridge

import bridge.domain.engine.BridgeGameEngine

fun main() {
    val gameEngine = BridgeGameEngine()
    gameEngine.init()
    gameEngine.run()
}