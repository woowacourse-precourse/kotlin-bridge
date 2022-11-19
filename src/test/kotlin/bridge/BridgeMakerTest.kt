package bridge

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class BridgeMakerTest {

    private val bridgeNumberGenerator = BridgeRandomNumberGenerator()

    @Test
    fun `다리에 U또는 D만 포함되어 있는지 확인`() {
        val bridge = BridgeMaker(bridgeNumberGenerator).makeBridge(5)
        val result = bridge.any { it != "U" && it != "D" }
        assertThat(result).isFalse
    }
}