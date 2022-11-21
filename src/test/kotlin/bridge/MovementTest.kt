package bridge

import bridge.domain.Movement
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class MovementTest {
    @ParameterizedTest
    @ValueSource(strings = ["1", "100", "2", "u", "d", "UU", "DD", "R", "L"])
    fun `이동 방향 예외 테스트`(direction: String) {
        assertThrows<IllegalArgumentException> {
            Movement(direction)
        }
    }
}