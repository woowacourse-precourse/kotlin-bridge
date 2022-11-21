package bridge.domain

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class BridgeMakerTest {

    @Test
    fun `다리생성_1or0_정상`() {
        val bridge: List<String> = generateBridge(1, 0, 0)
        assertThat(bridge).containsExactly("U", "D", "D")
    }

    @ParameterizedTest
    @ValueSource(ints = [-2, -1, 2, 3, 4, 5])
    fun `다리생성_not1or0_예외`(exceptionNumber: Int) {
        assertThrows<ArrayIndexOutOfBoundsException> {
            generateBridge(1, 0, 0, exceptionNumber)
        }
    }

    private fun generateBridge(vararg elements: Int): List<String> {
        val numberGenerator: BridgeNumberGenerator = TestNumberGenerator(elements.toList())
        val bridgeMaker = BridgeMaker(numberGenerator)
        return bridgeMaker.makeBridge(elements.size)
    }

    class TestNumberGenerator(numbers: List<Int>) : BridgeNumberGenerator {
        private val numbers: MutableList<Int> = numbers.toMutableList()

        override fun generate(): Int {
            return numbers.removeAt(0)
        }
    }
}