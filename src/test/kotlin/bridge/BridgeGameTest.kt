package bridge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BridgeGameTest {

    private lateinit var bridgeGame: BridgeGame

    @BeforeEach
    fun setUp() {
        val bridge = listOf("U", "U", "D")
        bridgeGame = BridgeGame(bridge)
    }

    @Test
    fun `건널 수 있는 칸 입력`() {
        val isFinished = bridgeGame.move("U")
        assertThat(isFinished).isFalse
    }

    @Test
    fun `건널 수 없는 칸 입력`() {
        val isFinished = bridgeGame.move("D")
        assertThat(isFinished).isTrue
    }

    @Test
    fun `다시 시도 시 초기화 여부`() {
        bridgeGame.move("U")
        bridgeGame.move("U")
        bridgeGame.move("D")
        bridgeGame.retry()
        val result = bridgeGame.count
        assertThat(result).isEqualTo(0)
    }
}