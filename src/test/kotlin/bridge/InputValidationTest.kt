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
        assertThrows<IllegalArgumentException> {
            inputValidation.checkInputInteger("1 ")
        }
        assertThrows<IllegalArgumentException> {
            inputValidation.checkInputInteger("13.3")
        }
    }

    @Test
    fun `다리 길이가 3이상 20이하가 아니라면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            inputValidation.checkBridgeSizeRange(21)
        }
        assertThrows<IllegalArgumentException> {
            inputValidation.checkBridgeSizeRange(0)
        }
        assertThrows<IllegalArgumentException> {
            inputValidation.checkBridgeSizeRange(120)
        }
    }


}