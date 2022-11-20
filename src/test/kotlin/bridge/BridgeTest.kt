package bridge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.provider.ValueSource

class BridgeTest {


    val numberGenerator: BridgeNumberGenerator = ApplicationTest.TestNumberGenerator(listOf(1, 0, 0))
    val bridgeMaker = BridgeMaker(numberGenerator)
    val bridgeMap: List<String> = bridgeMaker.makeBridge(3)
    val comBridge = Bridge(bridgeMap)

    @Test
    fun `이동 가능한 칸인지 확인`() {
        val userBridgeSpace = BridgeSpace(BridgeDirection.U, 0)
        val result = Move.POSSIBLE

        assertThat(comBridge.movePossible(userBridgeSpace)).isEqualTo(result)
    }

    @Test
    fun `이동 불가능한 칸인지 확인`() {
        val userBridgeSpace = BridgeSpace(BridgeDirection.U, 1)
        val result = Move.IMPOSSIBLE

        assertThat(comBridge.movePossible(userBridgeSpace)).isEqualTo(result)
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
        bridge.move(BridgeDirection.U, bridgeMap, 0)
        bridge.move(BridgeDirection.D, bridgeMap, 1)
        val upResult = "[ O |   ]"
        val downResult = "[   | O ]"
        assertThat(bridge.getUpBridgeResult()).isEqualTo(upResult)
        assertThat(bridge.getDownBridgeResult()).isEqualTo(downResult)
    }


    class TestNumberGenerator(numbers: List<Int>) : BridgeNumberGenerator {
        private val numbers: MutableList<Int> = numbers.toMutableList()

        override fun generate(): Int {
            return numbers.removeAt(0)
        }
    }
}