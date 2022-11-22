package bridge

import bridge.model.BridgeStatus
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("BridgeGame객체 테스트")
class BridgeGameTest {

    private lateinit var bridgeGame: BridgeGame

    @BeforeEach
    fun setUp() {
        bridgeGame = BridgeGame()
        bridgeGame.initGame(
            size = 5,
            maker = BridgeMaker(TestNumberGenerator(listOf(1, 0, 0, 1, 1)))
        )
    }

    @Test
    @DisplayName("다리 건너기를 완료할 경우를 테스트한다.")
    fun reachEndTest() {
        assertSimpleTest {
            val route = listOf("U", "D", "D", "U", "U")
            val result = listOf(
                BridgeStatus.SUCCESS("U"),
                BridgeStatus.SUCCESS("D"),
                BridgeStatus.SUCCESS("D"),
                BridgeStatus.SUCCESS("U"),
                BridgeStatus.FINISH("U")
            )
            route.forEachIndexed { idx, it ->
                assertThat(bridgeGame.move(it)).isInstanceOf(result[idx]::class.java)
            }
        }
    }

    @Test
    @DisplayName("다리 건너기 실패할 경우를 테스트한다.")
    fun reachFailTest() {
        assertSimpleTest {
            val route = listOf("U", "D", "U")
            val result = listOf(BridgeStatus.SUCCESS("U"), BridgeStatus.SUCCESS("D"), BridgeStatus.FAIL("U"))
            route.forEachIndexed { idx, it ->
                assertThat(bridgeGame.move(it)).isInstanceOf(result[idx]::class.java)
            }
        }
    }


    @ParameterizedTest
    @ValueSource(strings = ["Z", " ", "!", "가"])
    @DisplayName("다리를 움직일 때 방향이 D, U가 아니면 예외가 발생한다.")
    fun moveBridgeTest(direction: String) {
        assertThrows<IllegalArgumentException> {
            bridgeGame.move(direction)
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

    class TestNumberGenerator(numbers: List<Int>) : BridgeNumberGenerator {
        private val numbers: MutableList<Int> = numbers.toMutableList()
        override fun generate(): Int {
            return numbers.removeAt(0)
        }

    }


}