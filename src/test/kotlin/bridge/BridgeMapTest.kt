package bridge

import bridge.model.Bridge
import bridge.model.BridgeMap
import bridge.model.BridgeResult
import bridge.model.BridgeStatus
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

    @Test
    @DisplayName("브릿지맵 (U, D) 업데이트가 정상 작동하는지 테스트한다.")
    fun updateTest() {
        assertSimpleTest {
            bridgeMap.update(BridgeStatus.SUCCESS("U"))
            bridgeMap.update(BridgeStatus.FAIL("D"))
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
            bridgeMap.update(BridgeStatus.SUCCESS("U"))
            bridgeMap.update(BridgeStatus.SUCCESS("U"))
            bridgeMap.update(BridgeStatus.FINISH("D"))
            assertThat(bridgeMap.toString()).contains(
                "[ O | O |   ]",
                "[   |   | O ]",
            )
        }
    }
}