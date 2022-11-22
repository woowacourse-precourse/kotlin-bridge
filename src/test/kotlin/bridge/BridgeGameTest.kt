package bridge

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class BridgeGameTest {
    val bridgeGame = BridgeGame()

    @Nested
    inner class MoveTest {
        @Test
        fun `move 함수 정상작동 test 결과 true`() {
            assertThat(bridgeGame.move("U", 3, listOf("U", "D", "U", "U", "D"))).isTrue
        }

        @Test
        fun `move 함수 정상작동 test 결과 false`() {
            assertThat(bridgeGame.move("D", 3, listOf("U", "D", "U", "U", "D"))).isFalse
        }
    }

    @Nested
    inner class RetryTest {
        @Test
        fun `retry 함수 정상작동 test 입력 Q`() {
            assertThat(bridgeGame.retry("Q")).isEqualTo(GameState.QUIT)
        }

        @Test
        fun `retry 함수 정상작동 test 입력 R`() {
            assertThat(bridgeGame.retry("R")).isEqualTo(GameState.RESTART)
        }
    }
}
