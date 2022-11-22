package bridge

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class BridgeGameTest {

    @Test
    fun `Map의 key, value를 두 개의 리스트에 각각 저장`() {
        val mark = mutableMapOf("X" to " ")
        val markUp = mutableListOf<String>()
        val markDown = mutableListOf<String>()
        BridgeGame().move(mark, markUp, markDown)
        Assertions.assertThat(markUp).isEqualTo(listOf("X"))
        Assertions.assertThat(markDown).isEqualTo(listOf(" "))
    }

    @Test
    fun `X가 포함되어 있으면 true를 반환`() {
        val markUp = mutableListOf("X")
        val markDown = mutableListOf(" ")
        val result = BridgeGame().containsX(markUp, markDown)
        Assertions.assertThat(result).isEqualTo(true)
    }

    @Test
    fun `입력값과 다리의 값 비교하여 Map에 저장`() {
        val mark = "U"
        val bridge = listOf("U", "D", "D")
        val index = 0
        val bridgeMark = BridgeGame().markBridge(mark, bridge, index)
        Assertions.assertThat(bridgeMark).isEqualTo(mutableMapOf("O" to " "))
    }
}