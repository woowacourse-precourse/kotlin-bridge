package bridge.model

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BridgeGameCommandTest {

    @ValueSource(strings = ["T", "hi", "0", "r", "q", "ㄱ"])
    @ParameterizedTest
    fun `커맨드에 대문자 R이나 Q가 아닌 값이 들어올 경우 예외를 발생시킨다`(input: String) {
        assertThrows<IllegalArgumentException> {
            BridgeGameCommand.getByCommand(input)
        }
    }

    @Test
    fun `커맨드에 R이 들어올 경우 RETRY를 리턴시킨다`() {
        val input = "R"
        assert(
            BridgeGameCommand.getByCommand(input) == BridgeGameCommand.RETRY
        )
    }

    @Test
    fun `커맨드에 Q가 들어올 경우 QUIT를 리턴시킨다`() {
        val input = "Q"
        assert(
            BridgeGameCommand.getByCommand(input) == BridgeGameCommand.QUIT
        )
    }
}
