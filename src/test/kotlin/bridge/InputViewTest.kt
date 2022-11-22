package bridge

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputViewTest {

    @DisplayName("다리 사이즈 입력 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = ["-100", "0", "1", "2", "21", "ㄴ", "1!"])
    fun readBridgeSize(input: String) {
        assertThrows<IllegalArgumentException> {
            InputInspector().checkBridgeSize(input)
        }
    }

    @DisplayName("이동할 칸 입력 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = ["T", "P", "1", "!", "UY", "DU", "DB"])
    fun readMoving(input: String) {
        assertThrows<IllegalArgumentException> {
            InputInspector().checkMoving(input)
        }
    }

    @DisplayName("재실행 여부 입력 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = ["T", "P", "1", "!", "QY", "RU", "RQ"])
    fun readGameCommand(input: String) {
        assertThrows<IllegalArgumentException> {
            InputInspector().checkGameCommand(input)
        }
    }


}