package bridge

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputViewTest {

    @ValueSource(strings = [""])
    @ParameterizedTest
    fun `입력된 다리길이가 null인 경우 예외 테스트`(input: String) {
        assertThrows<IllegalArgumentException> {
            input.bridgeSizeInputTypeException()
        }
    }

    @ValueSource(strings = ["a", "?", "ㅈ"])
    @ParameterizedTest
    fun `입력된 다리길이가 숫자가 아닌 경우 예외 테스트`(input: String) {
        assertThrows<IllegalArgumentException> {
            input.bridgeSizeInputTypeException()

        }
    }

    @ValueSource(strings = ["2", "21", "-2", "0"])
    @ParameterizedTest
    fun `입력된 다리길이가 3이상 20이하가 아닌 경우 예외 테스트`(input: String) {
        assertThrows<IllegalArgumentException> {
            input.bridgeSizeInputTypeException()
        }
    }
}