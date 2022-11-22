package bridge.domain

import bridge.BridgeGame
import bridge.data.Games
import bridge.main
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BridgeGameTest : NsTest() {
    private val bridgeGame = BridgeGame()

    @Test
    fun `플레이어 칸 이동 테스트`() {
        val playerMoves = mutableListOf(listOf("O", " "))
        val upOrDown = Games.DOWN.game
        val alive = true
        val result = bridgeGame.move(playerMoves, upOrDown, alive)
        assertThat(result).isEqualTo(mutableListOf(listOf("O", " "), listOf(" ", "O")))
    }

    @Test
    fun `재시도 확인 테스트`() {
        val command = "R"
        val result = bridgeGame.retry(command)
        assertThat(result).isEqualTo(true)
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }

}