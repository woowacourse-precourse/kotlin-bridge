package bridge

import bridge.model.Bridge
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("Bridge객체 테스트")
class BridgeTest {

    @ParameterizedTest
    @ValueSource(strings = ["U,D,X", "U,U,!", "U,A,가"])
    @DisplayName("U또는 D가 아닌 리스트로 생성자가 호출될 때 예외가 발생한다.")
    fun constructorTest(bridge: String) {
        assertThrows<IllegalArgumentException> {
            Bridge(bridge.split(',').toList())
        }
    }
}