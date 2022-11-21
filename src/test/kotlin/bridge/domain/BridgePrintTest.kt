package bridge.domain

import bridge.shortBridge
import bridge.view.OutputView
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class BridgePrintTest {
    @Test
    fun `끝까지 출력`() {
        val bridge = listOf<String>("U", "D", "D", "D", "U")
        val answer = true

        Assertions.assertThat(
            OutputView().printMap(bridge, answer)
        )
    }

    @Test
    fun `3번째 라인까지 출력`() {
        val location = 2
        val bridge = listOf<String>("U", "D", "D", "D")
        val newBridge = shortBridge(bridge, location)
        val answer = true

        Assertions.assertThat(
            OutputView().printMap(newBridge, answer)
        )
    }

    @Test
    fun `도중에 틀릴 경우`() {
        val location = 1
        val bridge = listOf<String>("U", "D", "D")
        val newBridge = shortBridge(bridge, location)
        val answer = false

        Assertions.assertThat(
            OutputView().printMap(newBridge, answer)
        )
    }

    @Test
    fun `최종 결과 출력`() {
        val tryCount = 2
        val bridge = listOf<String>("U", "D", "D")
        val answer = false

        Assertions.assertThat(
            OutputView().printResult(bridge, answer, tryCount)
        )
    }

    @Test
    fun `게임 성공 여부 출력`() {
        val bridge = listOf<String>("U", "D", "D")

        Assertions.assertThat(
            OutputView().printResult(bridge, true, 3)
        )
        Assertions.assertThat(
            OutputView().printResult(bridge, false, 4)
        )
    }
}