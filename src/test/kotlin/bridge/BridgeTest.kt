package bridge

import bridge.model.Bridge
import bridge.model.BridgeDirection
import bridge.model.BridgeSpace
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

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
    fun `다리 이동 결과 확인하는 기능`() {
        var bridgeReulst = comBridge.move(listOf("D"))
        assertThat(bridgeReulst.upBridgeResult()).isEqualTo("[   ]")
        assertThat(bridgeReulst.downBridgeResult()).isEqualTo("[ X ]")

        bridgeReulst = comBridge.move(listOf("U", "D", "U"))
        assertThat(bridgeReulst.upBridgeResult()).isEqualTo("[ O |   | X ]")
        assertThat(bridgeReulst.downBridgeResult()).isEqualTo("[   | O |   ]")
    }


    class TestNumberGenerator(numbers: List<Int>) : BridgeNumberGenerator {
        private val numbers: MutableList<Int> = numbers.toMutableList()

        override fun generate(): Int {
            return numbers.removeAt(0)
        }
    }
}