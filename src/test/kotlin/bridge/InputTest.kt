package bridge

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputTest {

    @Test
    fun `입력 값에 아무 것도 없을 경우 테스트`() {
        assertThrows<IllegalArgumentException> {
            InputException().checkInputIsNull("")
        }
    }

    @Test
    fun `다리 길이 입력 값이 숫자가 아닐 경우 테스트`() {
        assertThrows<IllegalArgumentException> {
            InputException().checkBridgeLenInputIsNumeric("aa")
        }
    }

}