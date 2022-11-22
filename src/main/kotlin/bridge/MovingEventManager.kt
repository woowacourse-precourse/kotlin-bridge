package bridge

import bridge.model.GameMapState

class MovingEventManager {

    private val listeners: MutableList<MovingEventListener> = mutableListOf()

    fun subscribe(listener: MovingEventListener) = listeners.add(listener)

    fun unsubscribe(listener: MovingEventListener) = listeners.remove(listener)

    fun notify(gameMapState: GameMapState) = listeners.forEach { it.notify(gameMapState) }
}