package bridge

import bridge.model.Bridge
import bridge.model.BridgeResult
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BridgeGameTest {

    private lateinit var bridgeGame: BridgeGame

    @BeforeEach
    fun setUp() {
        bridgeGame = BridgeGame()
    }

    @ParameterizedTest
    @ValueSource(strings = ["Z", " ", "!", "가"])
    @DisplayName("다리를 움직일 때 방향이 D, U가 아니면 예외가 발생한다.")
    fun moveBridgeTest(direction: String) {
        assertThrows<IllegalArgumentException> {
            bridgeGame.move(direction)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["U,D,D,D,U"])
    @DisplayName("다리를 움직일 때 totalCount가 증가하는지 테스트한다.")
    fun moveBridgePositionTest(directions: String) {
        assertSimpleTest {
            bridgeGame.setBridge(Bridge(listOf("U", "U", "U", "U", "U")))
            directions.split(',').toList().forEach {
                bridgeGame.move(it)
            }
            assertThat(bridgeGame.calResult()).isEqualTo(5)
        }
    }

    @Test
    @DisplayName("다리 건너기를 완료할 경우를 테스트한다.")
    fun reachEndTest() {
        assertSimpleTest {
            val route = listOf("U", "D", "D")
            val result = listOf(BridgeResult.SUCCESS, BridgeResult.SUCCESS, BridgeResult.FINISH)
            bridgeGame.setBridge(Bridge(listOf("U", "D", "D")))
            route.forEachIndexed { idx, it ->
                assertThat(bridgeGame.move(it)).isEqualTo(result[idx])
            }
        }
    }

    @Test
    @DisplayName("다리 건너기 실패할 경우를 테스트한다.")
    fun reachFailTest() {
        assertSimpleTest {
            val route = listOf("U", "U", "U")
            val result = listOf(BridgeResult.SUCCESS, BridgeResult.SUCCESS, BridgeResult.FAIL)
            bridgeGame.setBridge(Bridge(listOf("U", "U", "D")))
            route.forEachIndexed { idx, it ->
                assertThat(bridgeGame.move(it)).isEqualTo(result[idx])
            }
        }
    }

    @Test
    @DisplayName("게임이 종료되었을 때 선택지(R,Q,예외 발생)를 테스트한다.")
    fun retryBridgeGameTest() {
        assertSimpleTest {
            assertThat(bridgeGame.retry("R")).isEqualTo(true)
            assertThat(bridgeGame.retry("Q")).isEqualTo(false)
        }
        assertThrows<IllegalArgumentException> {
            assertThat(bridgeGame.retry("X"))
        }
    }


}