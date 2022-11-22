package bridge

import bridge.model.GameResult
import bridge.model.GameState

class QuitEventManager {

    private val listeners: MutableList<QuitEventListener> = mutableListOf()

    fun subscribe(listener: QuitEventListener) = listeners.add(listener)

    fun unsubscribe(listener: QuitEventListener) = listeners.remove(listener)

    fun notify(gameState: GameState, gameResult: GameResult) = listeners.forEach { it.notify(gameState, gameResult) }
}