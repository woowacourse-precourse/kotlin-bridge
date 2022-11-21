package bridge

import bridge.model.GameState

class MovingEventManager {

    private val listeners: MutableList<MovingEventListener> = mutableListOf()

    fun subscribe(listener: MovingEventListener) = listeners.add(listener)

    fun unsubscribe(listener: MovingEventListener) = listeners.remove(listener)

    fun notify(event: GameState) = listeners.forEach { it.notify(event) }
}