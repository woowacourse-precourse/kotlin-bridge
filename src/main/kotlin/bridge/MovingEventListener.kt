package bridge

import bridge.model.GameMapState

interface MovingEventListener {

    fun notify(gameMapState: GameMapState)
}