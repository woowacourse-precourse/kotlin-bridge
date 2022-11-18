package bridge

import bridge.validator.InputValidator.validateInValidBridgeSize
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputViewTest {
    @Test
    fun `3이상 20이하의 숫자를 입력하지 않았을 때 예외처리`() {
        assertThrows<IllegalArgumentException> { validateInValidBridgeSize(1) }
    }
}