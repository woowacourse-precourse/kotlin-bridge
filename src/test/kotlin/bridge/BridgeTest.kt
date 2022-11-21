package bridge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BridgeTest {
    @Test
    fun `다리 개수 생성 테스트`() {
        val bridge = Bridge(BRIDGE_SIZE_EX)
        val result = bridge.getSize()
        assertThat(result).isEqualTo(BRIDGE_SIZE_EX)
    }

    companion object{
        private const val BRIDGE_SIZE_EX = 4
    }
}