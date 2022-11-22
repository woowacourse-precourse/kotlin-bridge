package bridge.domain

import bridge.BridgeMaker
import bridge.BridgeNumberGenerator
import bridge.util.ErrorMessage.ERROR_NOT_VALID_COMMAND
import java.lang.IllegalArgumentException

class BridgeGame(
    private val bridgeNumberGenerator: BridgeNumberGenerator,
    private val size: Int,
    private val player: Player
) {
    private var playerTryCount = 1
    private var bridge: List<String>

    init {
        val bridgeMaker = BridgeMaker(bridgeNumberGenerator)
        bridge = bridgeMaker.makeBridge(size)
    }

    fun move(move: String) {
        player.go(move)
    }

    fun isFail(): Boolean {
        return player.doNotGo(bridge)
    }

    fun isDone(): Boolean {
        return player.getRecord() == bridge
    }

    fun retry(type: String): Boolean {
        return when (type) {
            Command.QUIT.value() -> return false
            Command.RETRY.value() -> {
                initGame()
                return true
            }

            else -> throw IllegalArgumentException(ERROR_NOT_VALID_COMMAND)
        }
    }

    private fun initGame() {
        player.initialize()
        playerTryCount++
    }

    fun getTryCount(): Int {
        return playerTryCount
    }

    fun getBridge(): List<String> {
        return bridge
    }

    fun playerRecord(): List<String> {
        return player.getRecord()
    }
}
