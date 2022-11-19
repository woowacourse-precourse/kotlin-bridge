package bridge

import bridge.validator.BridgeGameValidator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BridgeGameTest {
    @Test
    fun `정답일 때 다음 라운드 반환 테스트`() {
        assertThat(1).isEqualTo(BridgeGameValidator.validateMoveOutput(true, 0))
    }

    @Test
    fun `정답이 아닐 때 현재 라운드 반환 테스트`() {
        assertThat(0).isEqualTo(BridgeGameValidator.validateMoveOutput(false, 0))
    }
}