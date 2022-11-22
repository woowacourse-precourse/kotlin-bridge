package bridge

import bridge.exception.Validator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidatorTest {
    private val validator = Validator()

    @Test
    fun `다리 길이 입력시 문자 입력 예외 검사`() {
        assertThrows<IllegalArgumentException> {
            validator.checkBridgeSize("a")
        }
    }

    @Test
    fun `다리 길이 입력시 범위 밖 숫자 입력 예외 검사`() {
        assertThrows<IllegalArgumentException> {
            validator.checkBridgeSize("40")
        }
    }

    @Test
    fun `이동할 칸 입력시 U나 D가 아닌 값 입력 예외 검사`() {
        assertThrows<IllegalArgumentException> {
            validator.checkMoving("A")
        }
    }

    @Test
    fun `이동할 칸 입력시 소문자 입력 예외 검사`() {
        assertThrows<IllegalArgumentException> {
            validator.checkMoving("u")
        }
    }

    @Test
    fun `재시도 및 게임 종료 입력시 R이나 Q가 아닌 값 입력 예외 검사`() {
        assertThrows<IllegalArgumentException> {
            validator.checkMoving("T")
        }
    }
}
