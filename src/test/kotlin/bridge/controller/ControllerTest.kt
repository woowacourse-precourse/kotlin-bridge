package bridge.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ControllerTest {
    companion object {
        val bridge = listOf<String>("U", "D", "U")
    }

    @Test
    fun `게임 실패 여부 테스트 1`() {
        val controller = BridgeGameController()
        controller.index = 1
        controller.upLine = mutableListOf<String>("O", "X")
        controller.downLine = mutableListOf<String>(" ", " ")
        assertThat(controller.judgeGameFailed()).isTrue
    }

    @Test
    fun `게임 성공 여부 테스트 1`() {
        val controller = BridgeGameController()
        controller.index = 2
        controller.upLine = mutableListOf<String>("O", " ", "O")
        controller.downLine = mutableListOf<String>(" ", "O", " ")
        assertThat(controller.judgeGameClear(bridge)).isTrue
    }
}