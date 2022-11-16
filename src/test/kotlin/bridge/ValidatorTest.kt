package bridge

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

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

    @ValueSource(strings = ["1?", "?", "ㅁ", "a"])
    @ParameterizedTest
    fun `입력된 다리길이가 숫자가 아닌 경우`(input : String) {
        assertThrows<IllegalArgumentException> {
            validator.checkLengthIsNum(input)
        }
    }
}