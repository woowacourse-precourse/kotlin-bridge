package bridge

import bridge.util.Validator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputTest {

    @ValueSource(strings = [" ", "a", "  1"])
    @ParameterizedTest
    fun `다리의 길이가 숫자 형태가 아니면 예외가 발생한다`(input: String) {
        assertThrows<IllegalArgumentException> {
            Validator.checkBridgeSize(input)
        }
    }

    @ValueSource(strings = [" ", "A", "  U", "1"])
    @ParameterizedTest
    fun `건널 다리에 대한 입력이 U 또는 D가 아니면 예외가 발생한다`(input: String) {
        assertThrows<IllegalArgumentException> {
            Validator.checkBridgeSelect(input)
        }
    }
}