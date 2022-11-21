package bridge.utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class MovementValidatorTest {
    private lateinit var validator: MovementValidator

    @BeforeEach
    fun setUp() {
        validator = MovementValidator()
    }

    @ParameterizedTest
    @ValueSource(strings = ["U", "D"])
    fun `U 또는 D 이면 예외가 발생하지 않는다`(input: String) {
        assertDoesNotThrow { validator.validate(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["u", "d", "a", "", " ", "R", "Q", "UU", "DD"])
    fun `U 또는 D 가 아니면 예외가 발생한다`(input: String) {
        val exception = assertThrows<IllegalArgumentException> { validator.validate(input) }
        assertThat(exception.message).isEqualTo(MovementValidator.ERROR_MESSAGE)
    }
}