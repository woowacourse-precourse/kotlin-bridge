package bridge

import bridge.model.GameMapStatus

interface MovingEventListener {

    fun update(gameMapStatus: GameMapStatus)
}