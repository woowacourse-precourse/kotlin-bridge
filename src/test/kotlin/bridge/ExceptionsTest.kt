package bridge

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ExceptionsTest {
    private val exceptions = Exceptions()

    @ValueSource(strings = ["1", "-1", "23", "a", "5g"])
    @ParameterizedTest
    fun `다리 길이 입력 예외 테스트`(input: String) {
        assertThrows<IllegalArgumentException> {
            exceptions.validateBridgeSize(input)
        }
    }

    @ValueSource(strings = ["u", "d", "2"])
    @ParameterizedTest
    fun `이동 입력 예외 테스트`(input: String) {
        assertThrows<IllegalArgumentException> {
            exceptions.validateMoving(input)
        }
    }

    @ValueSource(strings = ["q", "r", "2"])
    @ParameterizedTest
    fun `명령 입력 예외 테스트`(input: String) {
        assertThrows<IllegalArgumentException> {
            exceptions.validateCommand(input)
        }
    }
}