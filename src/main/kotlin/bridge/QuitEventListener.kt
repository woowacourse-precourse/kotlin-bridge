package bridge

import bridge.model.GameResult
import bridge.model.GameMapStatus

interface QuitEventListener {

    fun update(gameMapStatus: GameMapStatus, gameResult: GameResult)
}