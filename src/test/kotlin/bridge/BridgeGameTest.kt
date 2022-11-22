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
}