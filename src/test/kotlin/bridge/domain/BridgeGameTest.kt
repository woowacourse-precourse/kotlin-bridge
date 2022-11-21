package bridge.domain

import bridge.BridgeGame
import bridge.resources.QUIT
import bridge.resources.RETRY
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BridgeGameTest {

    @Test
    fun `move() 체크`() {
        val bridge = listOf<String>("U", "U", "D")
        val game = BridgeGame(bridge, bridge.size)
        assertThat(
            game.move(0) == listOf<String>("U")
                    && game.move(1) == listOf<String>("U", "U")
                    && game.move(2) == listOf<String>("U", "U", "D")
        ).isTrue()
    }

    @Test
    fun `retry() 체크`() {
        val bridge = listOf<String>("U", "U", "D")
        val game = BridgeGame(bridge, bridge.size)
        assertThat(game.retry(RETRY)).isTrue()
        assertThat(game.retry(QUIT)).isFalse()
    }
}