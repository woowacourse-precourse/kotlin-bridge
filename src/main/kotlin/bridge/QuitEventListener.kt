package bridge

import bridge.model.GameResult
import bridge.model.GameMapStatus

interface QuitEventListener {

    fun notify(gameMapStatus: GameMapStatus, gameResult: GameResult)
}