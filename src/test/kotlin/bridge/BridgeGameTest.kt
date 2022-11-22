package bridge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class BridgeGameTest {

    var answerbridge = listOf<String>("1")

    val bridgeGame = BridgeGame(answerbridge)

    @Test
    fun `게임 성공 여부 확인`() {
        bridgeGame.upBridge.add("X")
        bridgeGame.downBridge.add("X")

        assertThat(bridgeGame.choiceFail()).isEqualTo(true)
    }

    @Test
    fun `모든 다리를 건넜는지 확인`() {
        bridgeGame.inputBridge.add("1")

        assertThat(bridgeGame.choiceAll()).isEqualTo(true)

    }

    @Test
    fun `건넌 다리가 모두 맞는지 확인`() {
        bridgeGame.inputBridge.add("1")

        assertThat(bridgeGame.choiceSame()).isEqualTo(true)

    }
}