package bridge

import bridge.model.GameResult
import bridge.model.GameMapStatus

class QuitEventManager {

    private val listeners: MutableList<QuitEventListener> = mutableListOf()

    fun subscribe(listener: QuitEventListener) = listeners.add(listener)

    fun notify(gameMapStatus: GameMapStatus, gameResult: GameResult) = listeners.forEach { it.update(gameMapStatus, gameResult) }
}