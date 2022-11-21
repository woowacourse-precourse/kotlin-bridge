package bridge

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BridgeGameTest {
    val bridgeGame = BridgeGame()

    @Test
    fun `move 함수 정상작동 test 결과 true`() {
        assertThat(bridgeGame.move("U", 3, listOf("U", "D", "U", "U", "D"))).isTrue
    }

    @Test
    fun `move 함수 정상작동 test 결과 false`() {
        assertThat(bridgeGame.move("D", 3, listOf("U", "D", "U", "U", "D"))).isFalse
    }
}
