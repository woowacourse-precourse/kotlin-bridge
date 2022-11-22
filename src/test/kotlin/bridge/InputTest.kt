package bridge

import bridge.util.Validator
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputTest {

    @DisplayName("다리의 길이가 숫자 형태가 아니면 예외 발생")
    @ValueSource(strings = [" ", "a", "  1"])
    @ParameterizedTest
    fun testBridgeSize(input: String) {
        assertThrows<IllegalArgumentException> {
            Validator.checkBridgeSize(input)
        }
    }

    @DisplayName("건널 다리에 대한 입력이 U 또는 D가 아니면 예외 발생")
    @ValueSource(strings = [" ", "A", "  U", "1"])
    @ParameterizedTest
    fun testBridgeSelect(input: String) {
        assertThrows<IllegalArgumentException> {
            Validator.checkBridgeSelect(input)
        }
    }

    @DisplayName("게임 재시도와 종료에 대한 입력이 R 또는 Q가 아니면 예외 발생")
    @ValueSource(strings = [" ", "A", "  R", "1"])
    @ParameterizedTest
    fun testRetryOrQuit(input: String) {
        assertThrows<IllegalArgumentException> {
            Validator.checkCommand(input)
        }
    }
}