package bridge.domain

import bridge.util.Constant.LOAD_GO
import bridge.util.Constant.LOAD_STOP
import bridge.util.ErrorMessage.ERROR_NOT_VALID_COMMAND
import java.lang.IllegalArgumentException

class BridgeGame(private val player: Player, private val bridge: Bridge) {
    private var playerTryCount = 1

    fun move(move: String) {
        player.go(move)
    }

    fun isFail(): Boolean {
        return player.doNotGo(bridge)
    }

    fun isDone(): Boolean {
        return player.isFinish(bridge)
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

    fun compareWith(index: Int, move: String): String {
        return bridge.cross(index, move)
    }

    fun getTryCount(): Int {
        return playerTryCount
    }

    fun playerRecord(): List<String> {
        return player.getRecord()
    }
}
