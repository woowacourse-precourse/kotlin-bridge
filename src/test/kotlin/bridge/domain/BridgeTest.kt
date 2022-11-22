package bridge.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BridgeTest {
    @Test
    fun `다리 개수 생성 테스트`() {
        val bridge = Bridge(blocks)
        val result = bridge.getSize()
        assertThat(result).isEqualTo(blocks.size)
    }

    companion object {
        val blocks = listOf("U","D","D","U")
    }
}