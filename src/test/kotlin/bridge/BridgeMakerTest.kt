package bridge

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class BridgeMakerTest {

    @Test
    fun `다리를 생성한다`() {
        val numberGenerator: BridgeNumberGenerator = TestNumberGenerator(listOf(1, 0, 0))
        val bridgeMaker = BridgeMaker(numberGenerator)
        val bridge: List<String> = bridgeMaker.makeBridge(3)
        Assertions.assertThat(bridge.toString()).isEqualTo("[U, D, D]")
    }

    class TestNumberGenerator(numbers: List<Int>) : BridgeNumberGenerator {
        private val numbers: MutableList<Int> = numbers.toMutableList()

        override fun generate(): Int {
            return numbers.removeAt(0)
        }
    }
}