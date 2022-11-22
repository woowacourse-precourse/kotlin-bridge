package bridge.ui

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class ValidatorTest {
    private lateinit var validator: Validator

    @BeforeEach
    fun setUp() {
        validator = Validator()
    }

    @ParameterizedTest
    @ValueSource(strings = ["afasf", "ㅇ", "-", "ddd"])
    fun `다리 길이에 문자가 포함되어 있으면 예외 처리한다`(bridgeSize: String) {
        assertThatThrownBy {
            validator.handleMixedCharCase(bridgeSize)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(Validator.MIXED_CHAR_ERROR_MSG)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 0, -21, 40])
    fun `다리 길이가 3 이상 20 이하의 숫자가 아니면 예외 처리한다`(bridgeSize: Int) {
        assertThatThrownBy {
            validator.handleOutOfRangeCase(bridgeSize)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(Validator.RANGE_BOUNDS_ERROR_MSG)
    }

    @ParameterizedTest
    @ValueSource(strings = ["d", "DD", "adfa", "u"])
    fun `U 또는 D가 아닌 방향을 입력하면 예외 처리한다` (direction: String) {
        assertThatThrownBy {
            validator.handleExceptionalDirection(direction)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(Validator.UP_DOWN_ERROR_MSG)
    }

    @ParameterizedTest
    @ValueSource(strings = ["r", "q", "adfa", "RRR", "QQ"])
    fun `R 또는 Q가 아닌 명령어를 입력하면 예외 처리한다` (gameCommand: String) {
        assertThatThrownBy {
            validator.handleExceptionalCommand(gameCommand)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(Validator.RESTART_QUIT_ERROR_MSG)
    }
}