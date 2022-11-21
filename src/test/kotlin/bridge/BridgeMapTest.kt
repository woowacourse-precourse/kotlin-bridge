package bridge

import bridge.model.Bridge
import bridge.model.BridgeMap
import bridge.model.BridgeResult
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("BridgeMap객체 테스트")
class BridgeMapTest {

    private lateinit var bridgeMap: BridgeMap

    @BeforeEach
    fun setUp() {
        bridgeMap = BridgeMap()
    }

    @ParameterizedTest
    @ValueSource(strings = ["X", "1", "!"])
    @DisplayName("브릿지맵에 U, D가 아닌 다른값이 들어가면 예외가 발생한다.")
    fun constructorExceptionTest(direction: String) {
        assertThrows<IllegalArgumentException> {
            bridgeMap.update(BridgeResult.SUCCESS, direction)
        }
    }

    @Test
    @DisplayName("브릿지맵 (U, D) 업데이트가 정상 작동하는지 테스트한다.")
    fun updateTest() {
        assertSimpleTest {
            bridgeMap.update(BridgeResult.SUCCESS, "U")
            bridgeMap.update(BridgeResult.FAIL, "D")
            assertThat(bridgeMap.toString()).contains(
                "[ O |   ]",
                "[   | X ]",
            )
        }
    }

    @Test
    @DisplayName("브릿지맵 (U, U, D) 업데이트가 정상 작동하는지 테스트한다.")
    fun updateTest2() {
        assertSimpleTest {
            bridgeMap.update(BridgeResult.SUCCESS, "U")
            bridgeMap.update(BridgeResult.SUCCESS, "U")
            bridgeMap.update(BridgeResult.FINISH, "D")
            assertThat(bridgeMap.toString()).contains(
                "[ O | O |   ]",
                "[   |   | O ]",
            )
        }
    }
}