package bridge

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidatorTest {

    val validator = Validator()

    @Test
    fun `입력값이 빈 문자열일 경우 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            validator.checkEmptyInput("")
        }
    }

    @Test
    fun `입력값이 null일 경우 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            validator.checkInputNull(null)
        }
    }
}