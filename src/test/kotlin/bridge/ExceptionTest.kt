package bridge

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import util.Exception

class ExceptionTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 21, 22])
    fun `다리의 길이가 3-20 사이가 아니면 예외가 발생한다`(input: Int) {
        assertThrows<IllegalArgumentException> {
            Exception.validateBridgeSizeRange(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["2", "q", "f"])
    fun `이동할 칸이 위(U)와 아래(D)가 아니면 예외가 발생한다`(input: String) {
        assertThrows<IllegalArgumentException> {
            Exception.validateMovingCommand(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "s", " d", "재시작"])
    fun `재시작(R)과 종료(Q)가 아니면 예외가 발생한다`(input: String) {
        assertThrows<IllegalArgumentException> {
            Exception.validateGameCommand(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["number", "aaa"])
    fun `숫자로 변경 가능한 문자가 아니면 예외가 발생한다`(input: String) {
        assertThrows<IllegalArgumentException> {
            Exception.validateNumber(input)
        }
    }
}