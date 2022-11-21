package bridge.domain

import bridge.ApplicationTest
import bridge.ApplicationTest.*
import bridge.BridgeNumberGenerator
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BridgeTest {
    lateinit var bridge:Bridge
    @BeforeEach
    fun `다리 생성`() {
        val bridgeNumberGenerator: BridgeNumberGenerator = TestNumberGenerator(listOf(1, 0, 0))
        val bridgeMaker = BridgeMaker(bridgeNumberGenerator)
        bridge = Bridge(bridgeMaker.makeBridge(3))
    }
    @Test
    fun `isMovable 메서드에 위치와 방향 정보를 주어 해당 다리의 block을 건널 수 있는지 판단`() {
        val input = listOf(
            0 to Direction.UP,
            1 to Direction.UP,
            2 to Direction.DOWN,
            3 to Direction.UP)
        val result = input.map { bridge.isMovable(index = it.first, direction = it.second) }
        assertThat(result).containsExactly(true, false, true, false)
    }
}