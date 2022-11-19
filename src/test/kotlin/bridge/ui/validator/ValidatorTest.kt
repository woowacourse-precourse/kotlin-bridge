package bridge.ui.validator

import camp.nextstep.edu.missionutils.test.Assertions
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test


class ValidatorTest {
    @Test
    fun `다리 크기가 3 이상 20 이하의 숫자가 아니면 예외 발생`() {
        assertThatIllegalArgumentException().isThrownBy {
            InputValidator.validateBridgeSize(bridgeSize = "21")
        }
        .withMessageContaining(ERROR_MESSAGE)
    }

    @Test
    fun `이동할 칸 입력이 U 또는 D가 아닌 문자면 예외 발생`() {
        Assertions.assertSimpleTest {
            assertThatIllegalArgumentException().isThrownBy {
                InputValidator.validateBridgeSize(bridgeSize = "UD")
            }
                .withMessageContaining(ERROR_MESSAGE)
        }
    }

    @Test
    fun `게임 진행 여부 입력이 R 또는 Q가 아닌 문자면 예외 발생`() {
        Assertions.assertSimpleTest {
            assertThatIllegalArgumentException().isThrownBy {
                InputValidator.validateBridgeSize(bridgeSize = "RQ")
            }
                .withMessageContaining(ERROR_MESSAGE)
        }
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}