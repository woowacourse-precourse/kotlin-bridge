package bridge.domain

import bridge.domain.validator.ValidateMoving
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ValidateMovingTest {

    private val validateMoving: ValidateMoving = ValidateMoving()

    @ParameterizedTest
    @ValueSource(strings = ["u", "d", "ㄹ", " ", "", "123"])
    fun `이동할 칸 입력이 U 또는 D가 아닌 문자라면 예외를 던진다`(exceptionValue: String) {
        assertThrows<IllegalArgumentException> {
            validateMoving(exceptionValue)
        }
    }
}