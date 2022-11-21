package bridge

import bridge.domain.BridgeNumber
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BridgeNumberTest {
    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "21", "22", "100", "a", "12a", "ab12", "+", ""])
    fun `다리 길이 예외 테스트`(size: String) {
        assertThrows<IllegalArgumentException> {
            BridgeNumber(size)
        }
    }
}