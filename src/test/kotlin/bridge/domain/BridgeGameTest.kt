package bridge.domain

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

internal class BridgeGameTest {
    private val bridgeGame = BridgeGame(Player(Bridge(listOf<String>("U", "D", "U"))))

    @Test
    fun `이동하는 칸이 건널 수 있는 칸이면 true를 반환한다`() {
        assertThat(bridgeGame.move("U")).isTrue
    }

    @Test
    fun `이동하는 칸이 건널 수 없는 칸이면 false를 반환한다`() {
        assertThat(bridgeGame.move("D")).isFalse
    }
}