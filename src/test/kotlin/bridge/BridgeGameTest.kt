package bridge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BridgeGameTest {

    @ParameterizedTest
    @DisplayName("OX 다리에 0과, X가 포함되어 잘 만들어지는지 테스트한다.")
    @ValueSource(strings = ["D"])
    fun makeOXBridge(move: String) {
        val oxBridge = mutableListOf<MutableList<String>>(mutableListOf(), mutableListOf())
        for (index in 0 until 3) {
            if (move == "D") {
                oxBridge[0].add(" ")
                oxBridge[1].add("O")
            }
        }
        assertThat(oxBridge[1]).isEqualTo(mutableListOf("O", "O", "O"))
    }

    @ParameterizedTest
    @DisplayName("종료 커맨드가 잘 작동하는지 테스트한다.")
    @ValueSource(strings = ["Q"])
    fun workRetryQCommand(restartCommand: String) {
        var restartGame = true
        if (restartCommand == "Q") {
            restartGame = false
        }
        assertThat(restartGame).isEqualTo(false)
    }

    @ParameterizedTest
    @DisplayName("재시작 커맨드가 잘 작동하는지 테스트한다.")
    @ValueSource(strings = ["R"])
    fun workRetryRCommand(restartCommand: String) {
        var restartGame = false
        if (restartCommand == "R") {
            restartGame = true
        }
        assertThat(restartGame).isEqualTo(true)
    }
}
