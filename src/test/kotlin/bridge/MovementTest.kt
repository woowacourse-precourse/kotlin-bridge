package bridge

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class MovementTest {
    @ParameterizedTest
    @ValueSource(strings = ["1", "100", "2"])
    fun `이동 방향이 숫자인 경우 예외 테스트`(direction: String) {
        assertThrows<IllegalArgumentException> {
            Movement(direction)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["u", "d"])
    fun `이동 방향이 소문자인 경우 예외 테스트`(direction: String) {
        assertThrows<IllegalArgumentException> {
            Movement(direction)
        }
    }
}