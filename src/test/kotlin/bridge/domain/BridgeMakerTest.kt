package bridge.domain

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import bridge.Exception.BridgeLengthException
import bridge.resources.DOWN
import bridge.resources.UP
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class BridgeMakerTest {
    @Test
    fun `정상 길이`() {
        val size = 10
        val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(size)
        assertThat(
            bridge.size == size
        )
    }

    @Test
    fun `정상 요소`() {
        val size = 10
        val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(size)
        assertThat(
            bridge.filterNot { it == UP || it == DOWN }.isEmpty()
        )
    }
}