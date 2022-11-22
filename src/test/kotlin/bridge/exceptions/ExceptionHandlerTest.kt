package bridge.exceptions

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Test

internal class ExceptionHandlerTest {

    @Test
    fun `checkSize`() {
        assertThrows<IllegalArgumentException> {
            ExceptionHandler.checkSize(2)
        }
    }

    @Test
    fun `checkUpDown`() {
        assertThrows<IllegalArgumentException> {
            ExceptionHandler.checkUpDown("s")
        }
    }

    @Test
    fun `checkCommand`() {
        assertThrows<IllegalArgumentException> {
            ExceptionHandler.checkCommand("")
        }
    }
}