package bridge

import bridge.constants.BridgePhrases.INCORRECT_GAME_STATE_ERROR
import kotlin.properties.Delegates

class GameHost(private val bridgeMaker: BridgeMaker, private val bridgeGame: BridgeGame) {
    private lateinit var bridge: List<String>
    private var bridgeCurrentPosition = 0
    private lateinit var recentUserInput: String
    private var stageState by Delegates.notNull<Boolean>()
    private var gameState = GameState.INIT
    private var attemptNumber = 1

    fun makeBridge(bridgeSize: Int) {
        bridge = bridgeMaker.makeBridge(bridgeSize)
    }

    fun progressStage(userMovingInput: String): Boolean {
        recentUserInput = userMovingInput
        stageState = bridgeGame.move(userMovingInput, bridgeCurrentPosition, bridge)
        if (!stageState) gameState = GameState.Select
        if (bridgeCurrentPosition == bridge.size - 1 && stageState) gameState = GameState.END
        bridgeCurrentPosition += 1
        return stageState
    }

    fun getProperGameState(userGameCommandInput: String) {
        gameState = bridgeGame.retry(userGameCommandInput)
        if (gameState == GameState.RESTART) {
            attemptNumber += 1
            bridgeCurrentPosition = 0
        }
    }

    fun convertGameStateToGameResult(): GameResult {
        when (gameState) {
            GameState.END -> return GameResult.SUCCESS
            GameState.QUIT -> return GameResult.FAIL
        }
        throw IllegalStateException(INCORRECT_GAME_STATE_ERROR)
    }

    fun getBridgeCurrentPosition(): Int = bridgeCurrentPosition

    fun getBridge(): List<String> = bridge

    fun getRecentStageState(): Boolean = stageState

    fun getGameState(): GameState = gameState

    fun getAttemptNumber(): Int = attemptNumber
}
