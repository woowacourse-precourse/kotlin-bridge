package bridge

import bridge.model.Bridge
import bridge.model.BridgeStatus
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
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

    @Test
    @DisplayName("다리를 이동할 때 올바른 올바른 결과 값을 반환하는지 테스트한다.")
    fun moveTest() {
        assertSimpleTest {
            val bridge = Bridge(listOf("U", "D", "U"))
            assertThat(bridge.move(0, "U"))
                .isInstanceOf(BridgeStatus.SUCCESS::class.java)
            assertThat(bridge.move(0, "D"))
                .isInstanceOf(BridgeStatus.FAIL::class.java)
            assertThat(bridge.move(1, "D"))
                .isInstanceOf(BridgeStatus.SUCCESS::class.java)
        }
    }
}