package bridge

import exception.BridgeSize
import exception.GameOver
import exception.MovingSpace
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ExceptionTest {
    @Test
    fun `다리 길이가 숫자가 아닌 경우 예외가 발생한다`() {
        assertThrows<NumberFormatException> {
            BridgeSize().checkNumberFormatException("a".toInt())
        }
    }

    @Test
    fun `다리 길이가 3부터 20사이의 숫자가 아닌 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            BridgeSize().checkIllegalArgumentException(21)
        }
    }

    @Test
    fun `이동할 칸이 U나 D가 아닌 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            MovingSpace().checkException("I")
        }
    }

    @Test
    fun `재시도 및 종료가 R이나 Q가 아닌 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            GameOver().checkException("I")
        }
    }
}