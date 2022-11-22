package bridge

import bridge.common.GameState
import bridge.domain.BridgeGame
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.*
import java.util.stream.Stream

class BridgeGameTest {
    private val bridge = listOf("U", "U", "D", "U")
    private lateinit var bridgeGame: BridgeGame
    private val result = mutableListOf<GameState>()

    @BeforeEach
    fun `클래스 생성`() {
        bridgeGame = BridgeGame(bridge)
    }

    @ParameterizedTest
    @MethodSource("generateData")
    fun `move 함수 반환값 테스트`(directions: List<String>, states: List<GameState>) {
        directions.forEach {
            result.add(bridgeGame.move(it))
        }
        assertThat(result).isEqualTo(states)
    }

    companion object {
        @JvmStatic
        fun generateData(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf("U", "U", "D", "U"),
                    listOf(GameState.IN_GAME, GameState.IN_GAME, GameState.IN_GAME, GameState.SUCCESS)
                ),
                Arguments.of(
                    listOf("U", "D", "U", "U"),
                    listOf(GameState.IN_GAME, GameState.FAILURE, GameState.FAILURE, GameState.SUCCESS)
                )
            )
        }
    }
}
