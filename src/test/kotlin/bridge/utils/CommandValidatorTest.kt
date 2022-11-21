package bridge.utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CommandValidatorTest {
    private lateinit var validator: CommandValidator

    @BeforeEach
    fun setUp() {
        validator = CommandValidator()
    }

    @ParameterizedTest
    @ValueSource(strings = ["R", "Q"])
    fun `R 또는 Q 이면 예외가 발생하지 않는다`(input: String) {
        assertDoesNotThrow { validator.validate(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["r", "q", "a", "", " ", "U", "D", "RR", "QQ"])
    fun `R 또는 Q 가 아니면 예외가 발생한다`(input: String) {
        val exception = assertThrows<IllegalArgumentException> { validator.validate(input) }
        assertThat(exception.message).isEqualTo(CommandValidator.ERROR_MESSAGE)
    }
}