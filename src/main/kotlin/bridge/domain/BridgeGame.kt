package bridge.domain

import bridge.util.BridgeNumberGenerator
import java.lang.IllegalArgumentException

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(private val bridgeNumberGenerator: BridgeNumberGenerator, private val size: Int) {
    private var playerTryCount = 1
    private val player = Player()
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

    fun playerRecord(): List<String> {
        return player.getState()
    }

    fun getBridge(): List<String> {
        return bridge
    }

    fun isDone(): Boolean {
        return player.getState() == bridge
    }

    fun retry(type: String): Boolean {
        return when (type) {
            "Q" -> return false
            "R" -> {
                initGame()
                return true
            }

            else -> throw IllegalArgumentException("유효하지 않은 값이 존재합니다.")
        }
    }

    private fun initGame() {
        player.initialize()
        playerTryCount++
    }

    fun getTryCount(): Int {
        return playerTryCount
    }
}
