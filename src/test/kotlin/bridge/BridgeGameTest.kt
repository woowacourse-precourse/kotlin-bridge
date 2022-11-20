package bridge

import bridge.data.Games
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class BridgeGameTest {
    private val bridgeGame = BridgeGame()
    @Test
    fun `플레이어 칸 이동 테스트`() {
        val playerMoves = mutableListOf(listOf("O"," "))
        val upOrDown = Games.DOWN.game
        val alive = true
        val result = bridgeGame.move(playerMoves,upOrDown,alive)
        Assertions.assertThat(result).isEqualTo(mutableListOf(listOf("O"," "),listOf(" ","O")))
    }
}