package bridge

import bridge.util.InputValidator
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputValidatorTest {
    private lateinit var inputValidator: InputValidator

    @BeforeEach
    fun setUp() {
        inputValidator = InputValidator()
    }

    @ParameterizedTest
    @ValueSource(strings = ["hello", "안녕", "우테코 합격 기원", "x"])
    fun `bridge 사이즈의 입력이 숫자가 아닌 경우`(bridgeSize: String) {
        assertThrows<IllegalArgumentException> {
            inputValidator.validateBridgeInput(bridgeSize)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1000", "22", "0", "1"])
    fun `bridge 사이즈의 입력이 범위 안에 없는 경우`(bridgeSize: String) {
        assertThrows<IllegalArgumentException> {
            inputValidator.validateBridgeInput(bridgeSize)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["X", "UP", "DOWN", "HELLO", ""])
    fun `이동에 대한 입력이 U나 D가 아닌 경우`(direction: String) {
        assertThrows<IllegalArgumentException> {
            inputValidator.validateMoveInput(direction)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["HELLO", "QUIT", "RETRY", "QR", "RQ", ""])
    fun `재시작 혹은 종료에 대한 입력이 R이나 Q가 아닌 경우`(retryInput: String) {
        assertThrows<IllegalArgumentException> {
            inputValidator.validateRetryFlag(retryInput)
        }
    }

}