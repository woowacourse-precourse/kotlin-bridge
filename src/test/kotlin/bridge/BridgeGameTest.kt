package bridge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BridgeGameTest {
    val bridgeGame = BridgeGame()
    /*@Test
    fun compareAnswerTest(){
        assertThat(bridgeGame.compareAnswer(listOf("U","D","D","D"))).isEqualTo(listOf("U","D","UX","D"))
    }*/

    @Test
    fun resultToStringTest(){
        assertThat(bridgeGame.resultToUString(listOf("U","D","UX"))).isEqualTo("[ O |   | X ]\n")
        assertThat(bridgeGame.resultToDString(listOf("U","D","U"))).isEqualTo("[   | O |   ]\n")
        assertThat(bridgeGame.resultToString(listOf("U","D","UX"))).isEqualTo("[ O |   | X ]\n[   | O |   ]\n")

    }
}