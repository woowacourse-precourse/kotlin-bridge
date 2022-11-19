package bridge.domain

import bridge.util.BridgeNumberGenerator

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(private val bridgeNumberGenerator: BridgeNumberGenerator, private val size: Int) {

    private val player = Player()
    private var bridge: List<String>

    init {
        val bridgeMaker = BridgeMaker(bridgeNumberGenerator)
        bridge = bridgeMaker.makeBridge(size)
    }

    fun move(move: String) {
        player.go(move)
    }

    fun retry() {
    }

    fun playerRecord(): List<String> {
        return player.getState()
    }

    fun getBridge(): List<String> {
        return bridge
    }
}
