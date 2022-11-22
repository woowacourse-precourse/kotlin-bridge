package bridge.domain

import bridge.ApplicationTest
import bridge.BridgeMaker
import bridge.BridgeNumberGenerator
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BridgeGameTest {
    lateinit var bridgeGame: BridgeGame

    @BeforeEach
    fun `bridgeGame 초기화`() {
        val bridgeNumberGenerator: BridgeNumberGenerator = ApplicationTest.TestNumberGenerator(listOf(1, 0, 0))
        val bridgeMaker = BridgeMaker(bridgeNumberGenerator)
        val bridge = Bridge(bridgeMaker.makeBridge(3))
        bridgeGame = BridgeGame(bridge, Player())
    }

    @Test
    fun `move 메서드에 방향 정보를 인자로 주어 다리를 건너고 현재 플레이어의 다리 건너기 상태를 반환`() {
        val input = Direction.DOWN
        val result = bridgeGame.move(input).map { it.getDirection() to it.getIsMovable() }
        assertThat(result).contains(Direction.DOWN to false)
    }
}