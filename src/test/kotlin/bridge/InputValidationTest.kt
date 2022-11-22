package bridge

import bridge.validation.InputValidation
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class InputValidationTest {

    private val inputValidation = InputValidation()

    @Test
    fun `입력값이 정수가 아니라면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            inputValidation.checkInputInteger("십삼")
        }
    }

    @Test
    fun `다리 길이가 3이상 20이하가 아니라면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            inputValidation.checkBridgeSizeRange(21)
        }
    }

    @Test
    fun `입력값의 길이가 1이 아니라면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            inputValidation.checkInputLength("12")
        }
    }

    @Test
    fun `사용자의 이동할 칸 입력값이 'U' 또는 'D' 가 아니라면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            inputValidation.checkUserMovingValidation("K")
        }
    }

    @Test
    fun `사용자의 재시작,종료 입력값이 'R' 또는 'Q' 가 아니라면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            inputValidation.checkUserRestartValidation("K")
        }
    }
}