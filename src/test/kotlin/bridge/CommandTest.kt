package bridge

import bridge.domain.Command
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CommandTest {
    @ParameterizedTest
    @ValueSource(strings = ["1", "100", "2", "r", "q", "RR", "QQ", "U", "D", "A", "B"])
    fun `명령어 예외 테스트`(execution: String) {
        assertThrows<IllegalArgumentException> {
            Command(execution)
        }
    }
}