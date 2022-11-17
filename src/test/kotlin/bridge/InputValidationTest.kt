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


}