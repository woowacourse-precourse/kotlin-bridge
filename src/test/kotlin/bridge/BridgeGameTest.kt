package bridge

import bridge.common.GameState
import bridge.domain.BridgeGame
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BridgeGameTest {
    private val bridge = listOf("U", "U", "D", "U")
    private lateinit var bridgeGame: BridgeGame
    private val result = mutableListOf<GameState>()

    @BeforeEach
    fun `클래스 생성`() {
        bridgeGame = BridgeGame(bridge)
        result.clear()
    }

    @Test
    fun `move 함수 반환값 테스트 - IN_GAME, SUCCESS`() {
        val input = listOf("U", "U", "D", "U")
        input.forEach {
            result.add(bridgeGame.move(it))
        }
        assertThat(result).isEqualTo(listOf(GameState.IN_GAME, GameState.IN_GAME, GameState.IN_GAME, GameState.SUCCESS))
    }

    @Test
    fun `move 함수 반환값 테스트 - IN_GAME, FAILURE, SUCCESS`() {
        val input = listOf("U", "D", "U", "U")
        input.forEach {
            result.add(bridgeGame.move(it))
        }
        assertThat(result).isEqualTo(listOf(GameState.IN_GAME, GameState.FAILURE, GameState.FAILURE, GameState.SUCCESS))
    }
}
