package bridge.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ErrorCheckTest {

    @Test
    fun `입력받은 값이 정수가 아닌 경우 오류 발생`() {
        assertThrows<IllegalArgumentException> {
            ErrorCheck.checkIsInteger("a")
        }
    }
}