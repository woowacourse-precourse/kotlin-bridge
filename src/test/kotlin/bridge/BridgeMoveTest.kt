package bridge

import camp.nextstep.edu.missionutils.test.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BridgeMoveTest {

    private val bridge = listOf("U", "U", "U", "D")
    private val state = BridgeState()
    private val game = BridgeGame(state)

    @Test
    fun `다리 이동 성공 테스트`() {
        val result = state.isUserLive(bridge)
//        Assertions.assertSimpleTest {
//            assertThat{ state.bridgeMovePart(bridge). }
//        }
    }

    @Test
    fun `다리 이동 실패 테스트`() {

    }
}