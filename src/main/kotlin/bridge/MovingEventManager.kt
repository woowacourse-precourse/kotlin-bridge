package bridge

import bridge.model.GameState

class MovingEventManager {

    private val listeners: MutableList<MovingEventListener> = mutableListOf()

    fun subscribe(listener: MovingEventListener) = listeners.add(listener)

    fun unsubscribe(listener: MovingEventListener) = listeners.remove(listener)

    fun notify(gameState: GameState) = listeners.forEach { it.notify(gameState) }
}