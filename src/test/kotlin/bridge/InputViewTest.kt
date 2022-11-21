package bridge

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputViewTest {

    @Test
    fun `입력 값에 아무 것도 없을 경우 테스트`() {
        assertThrows<IllegalArgumentException> {
            InputException().checkInputIsNull("")
        }
    }

}