package bridge

import bridge.model.GameResult
import bridge.model.GameMapState

interface QuitEventListener {

    fun notify(gameMapState: GameMapState, gameResult: GameResult)
}