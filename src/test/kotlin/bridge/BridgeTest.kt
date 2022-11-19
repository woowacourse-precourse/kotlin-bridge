package bridge

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class BridgeTest {


    @Test
    fun `다리 길이 입력값이 숫자이고 올바른 범위인지 확인`() {
        assertThrows<IllegalArgumentException> {
            CheckException().checkInput("20")
        }
    }
}