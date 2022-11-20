package bridge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BridgeGameTest {
    val bridgeGame = BridgeGame()
    @Test
    fun compareAnswerTest(){
        var moveData = mutableListOf<String>("U","D","U","D")
        assertThat(bridgeGame.compareAnswer(listOf("U","D","D","D"))).isEqualTo(listOf("U","D","UX","D"))
    }
}