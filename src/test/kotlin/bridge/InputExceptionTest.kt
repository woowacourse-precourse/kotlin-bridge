package bridge

import net.bytebuddy.asm.Advice.ExceptionHandler
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import util.InputException

class InputExceptionTest {

    private val inputException = InputException()

    @Test
    fun `다리 길이 범위 예외 검사`() {
        assertThrows<IllegalArgumentException> { inputException.checkRangeException("d") }
    }

    @Test
    fun `다리 이동 입력값 예외 검사`() {
        assertThrows<IllegalArgumentException> { inputException.checkMoveCommand("A") }
    }

    @Test
    fun `재시도 여부 입력값 예외 검사`() {
        assertThrows<IllegalArgumentException> { inputException.checkRetryCommand("A") }
    }
}