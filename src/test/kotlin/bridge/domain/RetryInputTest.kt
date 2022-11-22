package bridge.domain

import bridge.Exception.MoveException
import bridge.Exception.RetryException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class RetryInputTest {
    @Test
    fun `retryInput에 null이 들어갈 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            MoveException.exceptions("")
        }
    }

    @Test
    fun `retryInput가 한 글자가 아닌 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            MoveException.exceptions("UD")
        }
    }

    @Test
    fun `retryInput가 R나 Q가 아닌 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            RetryException.exceptions("U")
        }
        assertThrows<IllegalArgumentException> {
            RetryException.exceptions("2")
        }
    }
}