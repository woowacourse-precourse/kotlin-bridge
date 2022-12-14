package bridge

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class BridgeMakerTest {

    @Test
    fun `입력받은 다리 길이만큼 다리가 생성되었다`() {
        val bridgeMaker = BridgeMaker(TestNumberGenerator(listOf(1, 1, 0))).makeBridge(3)

        Assertions.assertThat(bridgeMaker.toString()).isEqualTo("[U, U, D]")
    }
    @Test
    fun `입력받은 다리 길이만큼 다리 길이가 생성되었다`() {
        val bridgeMaker = BridgeMaker(TestNumberGenerator(listOf(1, 1, 0))).makeBridge(3)

        Assertions.assertThat(bridgeMaker).hasSize(3)
    }

    class TestNumberGenerator(numbers: List<Int>) : BridgeNumberGenerator {
        private val numbers: MutableList<Int> = numbers.toMutableList()

        override fun generate(): Int {
            return numbers.removeAt(0)
        }
    }
}