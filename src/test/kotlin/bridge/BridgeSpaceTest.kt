package bridge

import bridge.Move
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BridgeSpaceTest {

    val comBridgeSpace = BridgeSpace(BridgeDirection.U, 0)

    @Test
    fun `칸이 이동가능한지 확인`() {
        val userBridgeSpace = BridgeSpace(BridgeDirection.U, 0)
        val result = Move.POSSIBLE

        assertThat(comBridgeSpace.matchBridgeSpace(userBridgeSpace)).isEqualTo(result)
    }

    @ValueSource(ints = [0, 3])
    @ParameterizedTest
    fun `칸이 이동불가능한지 확인`(position : Int) {
        val userBridgeSpace = BridgeSpace(BridgeDirection.D, position)
        val result = Move.IMPOSSIBLE

        assertThat(comBridgeSpace.matchBridgeSpace(userBridgeSpace)).isEqualTo(result)
    }

}