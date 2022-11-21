package bridge

import bridge.domain.BridgeGame
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse

class BridgeGameTest {
    private val bridgeGame = BridgeGame(listOf("U", "D", "D", "U", "D"))

    @Test
    fun `이동할 수 있는 칸을 선택한 경우 게임 결과 검사`() {
        val result = bridgeGame.move("U", 0)
        assertTrue(result)
    }

    @Test
    fun `이동할 수 없는 칸을 선택한 경우 게임 결과 검사`() {
        val result = bridgeGame.move("D", 3)
        assertFalse(result)
    }

    @Test
    fun `사용자가 이동한 후 다리 모양 검사`() {
        bridgeGame.move("U", 0)
        bridgeGame.move("D", 1)
        bridgeGame.move("D", 2)
        bridgeGame.move("D", 3)
        val result = bridgeGame.getMapResult()
        assertThat(result).isEqualTo(Pair(listOf("O", " ", " ", " "), listOf(" ", "O", "O", "X")))
    }

    @Test
    fun `재시도를 두 번 한 경우 총 시도 횟수 검사`() {
        bridgeGame.retry()
        bridgeGame.retry()
        val result = bridgeGame.getTryCount()
        assertThat(result).isEqualTo(3)
    }
}
