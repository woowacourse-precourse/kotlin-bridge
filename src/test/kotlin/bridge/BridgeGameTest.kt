package bridge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BridgeGameTest {
    val bridgeGame = BridgeGame()
    @Test
    fun compareAnswerTest(){
        assertThat(bridgeGame.compareAnswer(listOf("U","D","D","D"))).isEqualTo(listOf("U","D","UX","D"))
    }

    fun resultToStringTest(){
        assertThat(bridgeGame.resultToString(listOf("U","D","UX"))).isEqualTo("[ O |   | X ]\n[   | O  |   ]\n")
        assertThat(bridgeGame.resultToString(listOf("U","D","U"))).isEqualTo("[ O |   | O ]\n[   | O  |   ]\n")
    }
}