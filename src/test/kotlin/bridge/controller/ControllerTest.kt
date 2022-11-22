package bridge.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ControllerTest {
    companion object {
        val bridge = listOf<String>("U", "D", "U")
        val BRIDGE_TOP = mutableListOf<String>("O", "X")
        val BRIDGE_DOWN = mutableListOf<String>(" ", " ")
    }

    @Test
    fun `게임 실패 여부 테스트 1`() {
        val controller = BridgeGameController()
        controller.upLine = BRIDGE_TOP
        controller.downLine = BRIDGE_DOWN
        assertThat(controller.judgeGameFailed(1)).isTrue
    }
}