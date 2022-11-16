package bridge.domain

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import bridge.resources.DOWN
import bridge.resources.UP
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BridgeMakerTest {
    @Test
    fun `정상적인 범주의 값이 나온다`() {
        val size = 10
        val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(size)
        println(bridge)
        assertThat(
            bridge.size == size && bridge.containsAll(listOf(UP, DOWN))
        )
    }
}