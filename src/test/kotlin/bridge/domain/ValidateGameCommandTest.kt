package bridge.domain

import bridge.domain.validator.ValidateGameCommand
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ValidateGameCommandTest {

    private val validateGameCommand: ValidateGameCommand = ValidateGameCommand()

    @ParameterizedTest
    @ValueSource(strings = ["r", "q", "U", "D", " ", "", "4"])
    fun `재시작 혹은 종료에 대한 입력이 R이나 Q가 아닌 경우 예외를 던진다`(exceptionValue: String) {
        assertThrows<IllegalArgumentException> {
            validateGameCommand(exceptionValue)
        }
    }
}