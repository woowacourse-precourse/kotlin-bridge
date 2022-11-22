package bridge

import kotlin.properties.Delegates

class GameHost(private val bridgeMaker: BridgeMaker, private val bridgeGame: BridgeGame) {
    private lateinit var bridge: List<String>
    private var bridgeCurrentPosition = 0
    private lateinit var recentUserInput: String
    private var stageState by Delegates.notNull<Boolean>()
    private var gameState = GameState.INIT

    fun makeBridge(bridgeSize: Int) {
        bridge = bridgeMaker.makeBridge(bridgeSize)
    }

    fun progressStage(userMovingInput: String): Boolean {
        recentUserInput = userMovingInput
        stageState = bridgeGame.move(userMovingInput, bridgeCurrentPosition, bridge)
        return stageState
    }

    fun getProperGameState(userGameCommandInput: String) {
        gameState = bridgeGame.retry(userGameCommandInput)
    }

    fun getBridgeCurrentPosition(): Int = bridgeCurrentPosition

    fun getBridge(): List<String> = bridge

    fun getRecentStageState(): Boolean = stageState

    fun getGameState(): GameState = gameState
}
