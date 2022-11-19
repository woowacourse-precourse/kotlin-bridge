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
        val result = bridgeGame.colPosition
        assertThat(result).isEqualTo(0)
    }

    @Test
    fun `총 시도한 횟수가 한 번일 경우`() {
        bridgeGame.move("U")
        bridgeGame.move("U")
        bridgeGame.move("D")
        val result = bridgeGame.tryCount
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun `총 시도한 횟수가 세 번일 경우`() {
        bridgeGame.move("D")
        bridgeGame.retry()
        bridgeGame.move("D")
        bridgeGame.retry()
        bridgeGame.move("U")
        bridgeGame.move("U")
        bridgeGame.move("D")
        val result = bridgeGame.tryCount
        assertThat(result).isEqualTo(3)
    }
}