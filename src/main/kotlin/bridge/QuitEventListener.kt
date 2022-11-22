package bridge

import bridge.model.GameResult
import bridge.model.GameState

interface QuitEventListener {

    fun notify(gameState: GameState, gameResult: GameResult)
}