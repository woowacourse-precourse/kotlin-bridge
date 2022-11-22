package bridge

import bridge.model.GameResult
import bridge.model.GameMapState

class QuitEventManager {

    private val listeners: MutableList<QuitEventListener> = mutableListOf()

    fun subscribe(listener: QuitEventListener) = listeners.add(listener)

    fun unsubscribe(listener: QuitEventListener) = listeners.remove(listener)

    fun notify(gameMapState: GameMapState, gameResult: GameResult) = listeners.forEach { it.notify(gameMapState, gameResult) }
}