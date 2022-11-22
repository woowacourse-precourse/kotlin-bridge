package bridge

import bridge.common.GameCommand.Companion.INVALID_COMMAND
import bridge.view.InputValidator
import bridge.view.InputValidator.Companion.INVALID_DIRECTION
import bridge.view.InputValidator.Companion.NOT_NUMBER
import bridge.view.InputValidator.Companion.NUMBER_NOT_IN_RANGE
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputValidatorTest {
    private val inputValidator = InputValidator()

    @ParameterizedTest
    @ValueSource(strings = ["a", "b", "|", "+"])
    fun `다리 길이 입력이 숫자인지 확인`(input: String) {
        assertSimpleTest {
            assertThatThrownBy {
                inputValidator.checkBridgeSizeInputValid(input)
            }.isExactlyInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining(NOT_NUMBER)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "0", "21", "2"])
    fun `다리 길이 입력이 범위 내인지 확인`(input: String) {
        assertSimpleTest {
            assertThatThrownBy {
                inputValidator.checkBridgeSizeInputValid(input)
            }.isExactlyInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining(NUMBER_NOT_IN_RANGE)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["d", "r", "a", "/"])
    fun `입력한 다리 방향의 유효성 테스트`(input: String) {
        assertSimpleTest {
            assertThatThrownBy {
                inputValidator.checkMovingInputValid(input)
            }.isExactlyInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining(INVALID_DIRECTION)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["ㄱ", "r", "q", ","])
    fun `재시도 여부 입력 유효성 테스트`(input: String) {
        assertSimpleTest {
            assertThatThrownBy {
                inputValidator.checkGameCommandValid(input)
            }.isExactlyInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining(INVALID_COMMAND)
        }
    }
}
