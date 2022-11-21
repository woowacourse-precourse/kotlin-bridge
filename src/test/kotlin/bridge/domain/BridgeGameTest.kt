package bridge.domain

import bridge.ApplicationTest
import bridge.util.BridgeNumberGenerator
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class BridgeGameTest {

    private lateinit var numberGenerator: BridgeNumberGenerator

    @BeforeEach
    fun setUp() {
        numberGenerator = ApplicationTest.TestNumberGenerator(listOf(1, 0, 0))
    }

    @ParameterizedTest
    @MethodSource("playerStateCheck")
    @DisplayName("move() 함수 테스트")
    fun `이동할칸_입력받아_플레이어_전진하는지_확인`(input: String, result: List<String>) {
        val bridgeGame = BridgeGame(numberGenerator, 3, player)
        bridgeGame.move(input)

        Assertions.assertThat(player.getRecord()).isEqualTo(result)
    }

    @Test
    @DisplayName("isDone() 함수 테스트")
    fun `플레이어가_다리를_다_건넜는지_확인`() {
        val bridgeGame = BridgeGame(numberGenerator, 3, player)

        Assertions.assertThat(bridgeGame.isDone()).isTrue
    }

    @Test
    @DisplayName("retry() 함수 테스트1")
    fun `게임_재시작시_플레이어_게임진행_횟수_증가`() {
        val player = Player()
        val bridgeGame = BridgeGame(numberGenerator, 3, player)
        bridgeGame.move("D")
        bridgeGame.retry("R")

        val tryCount = 2

        assertAll(
            { Assertions.assertThat(tryCount).isEqualTo(bridgeGame.getTryCount()) },
            { Assertions.assertThat(player.getRecord().isEmpty()) }
        )
    }

    @ParameterizedTest
    @CsvSource("D,true")
    @DisplayName("isFail() 함수 테스트")
    fun `다리를_못건널_경우_게임_중단_확인`(input: String, result: Boolean) {
        val player = Player()
        val bridgeGame = BridgeGame(numberGenerator, 3, player)
        bridgeGame.move(input)
        Assertions.assertThat(bridgeGame.isFail()).isEqualTo(result)
    }

    companion object {
        private val player = Player() /** move(), isDone() 함수 때 사용 **/

        @JvmStatic
        private fun playerStateCheck() = Stream.of(
            Arguments.of("U", listOf("U")),
            Arguments.of("D", listOf("U", "D")),
            Arguments.of("D", listOf("U", "D", "D"))
        )
    }
}
