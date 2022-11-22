package bridge

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class BridgeGameTest {

    lateinit var bridge: List<String>

    @Test
    fun `사용자가 칸을 이동하는 무브 테스트`() {
        bridge = listOf("D", "U", "D")
        val bridgeGame = BridgeGame(bridge)
        bridgeGame.move("D")
        val userMoveDirections = bridgeGame.move("U")
        Assertions.assertThat(userMoveDirections).containsExactly("D", "U")
    }


    @Test
    fun `사용자가 게임을 다시 시도할 때 테스트`() {
        bridge = listOf("U", "U", "U", "D")
        val bridgeGame = BridgeGame(bridge)
        val userCommand = bridgeGame.retry("R")
        Assertions.assertThat(userCommand).isEqualTo(true)
    }

    @Test
    fun `사용자가 게임을 다시 시도하지 않을 때 테스트`() {
        bridge = listOf("U", "U", "U", "D")
        val bridgeGame = BridgeGame(bridge)
        val userCommand = bridgeGame.retry("Q")
        Assertions.assertThat(userCommand).isEqualTo(false)
    }

}