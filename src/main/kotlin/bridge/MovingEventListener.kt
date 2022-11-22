package bridge

import bridge.model.GameMapStatus

interface MovingEventListener {

    fun notify(gameMapStatus: GameMapStatus)
}