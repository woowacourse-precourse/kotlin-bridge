package bridge

import kotlin.properties.Delegates

class GameHost(private val bridgeMaker: BridgeMaker, private val bridgeGame: BridgeGame) {
    private lateinit var bridge: List<String>
    private var bridgeCurrentPosition = 0
    private lateinit var recentUserInput: String
    private var stageState by Delegates.notNull<Boolean>()

    fun makeBridge(bridgeSize: Int) {
        bridge = bridgeMaker.makeBridge(bridgeSize)
    }

    fun progressStage(userMovingInput: String): Boolean {
        recentUserInput = userMovingInput
        stageState = bridgeGame.move(userMovingInput, bridgeCurrentPosition, bridge)
        return stageState
    }

    fun getBridgeCurrentPosition(): Int = bridgeCurrentPosition

    fun getBridge(): List<String> = bridge
}
