package bridge

import bridge.view.validator.InputValidator.validateInValidBridgeSize
import bridge.view.validator.InputValidator.validateInvalidGameCommand
import bridge.view.validator.InputValidator.validateInvalidMoveInput
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputViewTest {
    @Test
    fun `3이상 20이하의 숫자를 입력하지 않았을 때 예외`() {
        assertThrows<IllegalArgumentException> { validateInValidBridgeSize(1) }
    }

    @Test
    fun `U 또는 D가 아닌 값을 입력했을 때 예외`() {
        assertThrows<IllegalArgumentException> { validateInvalidMoveInput("F") }
    }

    @Test
    fun `Q 또는 R 아닌 값을 입력했을 때 예외`() {
        assertThrows<IllegalArgumentException> { validateInvalidGameCommand("a") }

    }
}