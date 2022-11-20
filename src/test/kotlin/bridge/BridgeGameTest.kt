package bridge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BridgeGameTest {

    val bridgeGame = BridgeGame(3)

    @Test
    fun `재시도 한번도 안했을 때 게임 시도 횟수 확인`() {
        val result = 1
        assertThat(bridgeGame.getGameCount()).isEqualTo(result)
    }

    @Test
    fun `재시도 했을 경우 게임 시도 횟수 확인`() {
        bridgeGame.retry()
        bridgeGame.retry()
        val result = 3
        assertThat(bridgeGame.getGameCount()).isEqualTo(result)
    }
}