package bridge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.provider.ValueSource

class BridgeTest {


    val numberGenerator: BridgeNumberGenerator = ApplicationTest.TestNumberGenerator(listOf(1, 0, 0))
    val bridgeMaker = BridgeMaker(numberGenerator)
    val bridgeMap: List<String> = bridgeMaker.makeBridge(3)
    var bridge = Bridge(3)

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

    @Test
    fun `이동가능한 칸이면 'O'인지 확인`() {
        val result = "O"
        assertThat(bridge.movePossibleMark(true)).isEqualTo(result)
    }

    @Test
    fun `이동 불가능한 칸이면 'X'인지 확인`() {
        val result = "X"
        assertThat(bridge.movePossibleMark(false)).isEqualTo(result)
    }

    @Test
    fun `다리 이동 결과 확인하는 기능`() {
        bridge.move("U", bridgeMap)
        bridge.move("D", bridgeMap)
        val upResult = "[ O |   ]"
        val downResult = "[   | O ]"
        assertThat(bridge.upBridgeResult()).isEqualTo(upResult)
        assertThat(bridge.downBridgeResult()).isEqualTo(downResult)
    }


    class TestNumberGenerator(numbers: List<Int>) : BridgeNumberGenerator {
        private val numbers: MutableList<Int> = numbers.toMutableList()

        override fun generate(): Int {
            return numbers.removeAt(0)
        }
    }
}