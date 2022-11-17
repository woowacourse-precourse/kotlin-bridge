package bridge

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
}