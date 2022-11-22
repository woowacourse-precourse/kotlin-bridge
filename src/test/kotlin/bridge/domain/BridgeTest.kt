package bridge.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BridgeTest {
    private val bridge = Bridge(blocks)

    @Test
    fun `다리 개수 생성 테스트`() {
        val result = bridge.getSize()
        assertThat(result).isEqualTo(blocks.size)
    }

    @Test
    fun `다리를 건널 수 없음 테스트`() {
        val index = 0
        val playerMove = DOWN
        val result = bridge.crossable(index, playerMove)
        assertThat(result).isEqualTo(false)
    }

    @Test
    fun `다리를 건널 수 있음 테스트`() {
        val index = 3
        val playerMove = UP
        val result = bridge.crossable(index, playerMove)
        assertThat(result).isEqualTo(true)
    }

    companion object {
        val blocks = listOf("U", "D", "D", "U")
        private const val UP = "U"
        private const val DOWN = "D"
    }
}