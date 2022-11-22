package bridge

import bridge.model.GameMapStatus

class MovingEventManager {

    private val listeners: MutableList<MovingEventListener> = mutableListOf()

    fun subscribe(listener: MovingEventListener) = listeners.add(listener)

    fun unsubscribe(listener: MovingEventListener) = listeners.remove(listener)

    fun notify(gameMapStatus: GameMapStatus) = listeners.forEach { it.notify(gameMapStatus) }
}