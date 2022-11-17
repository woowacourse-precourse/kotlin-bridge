package bridge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.provider.ValueSource

class BridgeTest {


    val numberGenerator: BridgeNumberGenerator = ApplicationTest.TestNumberGenerator(listOf(1, 0, 0))
    val bridgeMaker = BridgeMaker(numberGenerator)
    val bridgeMap: List<String> = bridgeMaker.makeBridge(3)
    val bridge = Bridge(3)

    @Test
    fun `이동 가능한 칸인지 확인`() {
        val input = "U"
        val result = true
        assertThat(bridge.movePossible(input, bridgeMap)).isEqualTo(result)
    }

    @Test
    fun `이동 불가능한 칸인지 확인`() {
        val input = "D"
        val result = false
        assertThat(bridge.movePossible(input, bridgeMap)).isEqualTo(result)
    }



    class TestNumberGenerator(numbers: List<Int>) : BridgeNumberGenerator {
        private val numbers: MutableList<Int> = numbers.toMutableList()

        override fun generate(): Int {
            return numbers.removeAt(0)
        }
    }
}