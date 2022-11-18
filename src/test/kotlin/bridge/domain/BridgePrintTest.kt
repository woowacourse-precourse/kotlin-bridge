package bridge.domain

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import bridge.resources.DOWN
import bridge.resources.UP
import bridge.view.OutputView
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class BridgePrintTest {
    @Test
    fun `끝까지 출력`() {
        val bridge = listOf<String>("U", "D", "D", "D", "U")
        val location = bridge.size - 1
        val answer = true

        Assertions.assertThat(
            OutputView().printMap(bridge, location, answer)
        )
    }

    @Test
    fun `3번째 라인까지 출력`() {
        val location = 2
        val bridge = listOf<String>("U", "D", "D", "D")
        val answer = true

        Assertions.assertThat(
            OutputView().printMap(bridge, location, answer)
        )
    }

    @Test
    fun `도중에 틀릴 경우`() {
        val location = 1
        val bridge = listOf<String>("U", "D", "D")
        val answer = false

        Assertions.assertThat(
            OutputView().printMap(bridge, location, answer)
        )
    }

}