package bridge.utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class BridgeValidatorTest {
    private lateinit var validator: BridgeValidator

    @BeforeEach
    fun setUp() {
        validator = BridgeValidator()
    }

    @ParameterizedTest
    @ValueSource(strings = ["3", "10", "20"])
    fun `다리 길이가 3 부터 20 사이의 숫자이면 예외가 발생하지 않는다`(input: String) {
        assertDoesNotThrow { validator.validate(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "2", "21", "", " ", "a"])
    fun `다리 길이가 3 부터 20 사이의 숫자가 아니면 예외가 발생한다`(input: String) {
        val exception = assertThrows<IllegalArgumentException> { validator.validate(input) }
        assertThat(exception.message).isEqualTo(BridgeValidator.ERROR_MESSAGE)
    }
}