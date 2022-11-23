package bridge

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = ["50", "abc", "일", "", " ", "-1", "05", "5!"])
    fun `다리 길이 입력 예외처리 테스트`(input: String) {
        assertThrows<IllegalArgumentException> {
            InputValidator.checkBridgeLength(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["u", "d", "아래", "", " ", "UD"])
    fun `이동 방향 입력 예외처리 테스트`(input: String) {
        assertThrows<IllegalArgumentException> {
            InputValidator.checkMoveDirection(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["r", "q", "종료", "재시작", "R ", "Rq", "RQ", "", " "])
    fun `재시작 입력 예외처리 테스트`(input: String) {
        assertThrows<IllegalArgumentException> {
            InputValidator.checkRetryOrQuit(input)
        }
    }
}
