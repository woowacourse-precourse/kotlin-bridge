package bridge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BridgeTest {

    @Test
    fun `다리의 최소 길이보다 짧으면 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            Bridge(listOf("U", "U"))
        }
    }

    @Test
    fun `다리를 건널 수 있다`() {
        assertThat(testBridge.isCrossable(0, "U")).isEqualTo(true)
    }

    @Test
    fun `다리를 건널 수 없다`() {
        assertThat(testBridge.isCrossable(1, "U")).isEqualTo(false)
    }

    companion object {
        lateinit var testBridge: Bridge

        @BeforeAll
        @JvmStatic
        fun initBridge() {
            testBridge = Bridge(listOf("U", "D", "D"))
        }
    }
}