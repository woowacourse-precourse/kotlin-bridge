package bridge

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ExceptionTest {
    @ParameterizedTest
    @ValueSource(strings = ["1", "21", "", " "])
    fun `다리의 길이가 3이상 20이하 숫자가 아니고 숫자가 아니면 예외 발생`(bridgeSize: String) {
        assertThatIllegalArgumentException().isThrownBy {
            InputView().inputBridgeException(bridgeSize)
        }
            .withMessageContaining(ERROR_MESSAGE)
    }

    @ParameterizedTest
    @ValueSource(strings = ["u", "d", "a", " ", ""])
    fun `플레이어가 이동할 칸 U와 D가 아니면 예외 발생`(inputMoving: String) {
        assertThatIllegalArgumentException().isThrownBy {
            InputView().inputMovingException(inputMoving)
        }
            .withMessageContaining(ERROR_MESSAGE)
    }

    @ParameterizedTest
    @ValueSource(strings = ["r", "q", "a", " ", ""])
    fun `게임 재시작,종료 R과 Q가 아니면 예외 발생`(inputGameCommand: String) {
        assertThatIllegalArgumentException().isThrownBy {
            InputView().inputMovingException(inputGameCommand)
        }
            .withMessageContaining(ERROR_MESSAGE)
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}