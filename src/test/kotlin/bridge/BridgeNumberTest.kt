package bridge

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BridgeNumberTest {
    @ParameterizedTest
    @ValueSource(strings = ["1,2,21,22,100"])
    fun `다리 길이의 범위 예외 테스트`(size: String) {
        assertThrows<IllegalArgumentException> {
            BridgeNumber(size)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["a", "12a", "ab12", "+"])
    fun `다리 길이가 숫자가 아닌 경우 예외 테스트`(size: String) {
        assertThrows<IllegalArgumentException> {
            BridgeNumber(size)
        }
    }

    @Test
    fun `다리 길이를 입력하지 않은 경우 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            BridgeNumber("")
        }
    }
}