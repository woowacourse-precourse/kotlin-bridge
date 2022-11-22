package bridge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BridgeMarkerTest {
    @Test
    fun `입력대로 다리를 잘 생성하는지 테스트`() {
        val bridgeMaker = BridgeMaker(TestNumberGenerator(listOf(1, 0, 0, 1, 0)))
        assertThat(bridgeMaker.makeBridge(5)).containsExactly("U", "D", "D", "U", "D")
    }

    class TestNumberGenerator(numbers: List<Int>) : BridgeNumberGenerator {
        private val numbers: MutableList<Int> = numbers.toMutableList()

        override fun generate(): Int {
            return numbers.removeAt(0)
        }
    }
}