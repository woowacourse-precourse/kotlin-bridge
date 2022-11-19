package bridge.ui.validator

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource


class ValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["2", "21", ""])
    fun `다리 크기가 3 이상 20 이하의 숫자가 아니면 예외 발생`(bridgeSize: String) {
        assertThatIllegalArgumentException().isThrownBy {
            InputValidator.validateBridgeSize(bridgeSize = bridgeSize)
        }
            .withMessageContaining(ERROR_MESSAGE)
    }

    @ParameterizedTest
    @ValueSource(strings = ["UD", "A", ""])
    fun `이동할 칸 입력이 U 또는 D가 아닌 문자면 예외 발생`(moving: String) {
        assertThatIllegalArgumentException().isThrownBy {
            InputValidator.validateMoving(moving = moving)
        }
            .withMessageContaining(ERROR_MESSAGE)
    }

    @ParameterizedTest
    @ValueSource(strings = ["RQ", "A", ""])
    fun `게임 진행 여부 입력이 R 또는 Q가 아닌 문자면 예외 발생`(command: String) {
        assertThatIllegalArgumentException().isThrownBy {
            InputValidator.validateGameCommand(command = command)
        }
            .withMessageContaining(ERROR_MESSAGE)
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}