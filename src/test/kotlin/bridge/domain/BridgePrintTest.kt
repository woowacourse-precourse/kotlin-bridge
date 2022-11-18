package bridge.domain

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

    @Test
    fun `최종 결과 출력`() {
        val location = 2
        val bridge = listOf<String>("U", "D", "D")
        val answer = false

        Assertions.assertThat(
            OutputView().printResult(bridge, location, answer)
        )
    }

    @Test
    fun `게임 성공 여부 출력`() {
        Assertions.assertThat(
            OutputView().printEnd(true, 3)
        )
        Assertions.assertThat(
            OutputView().printEnd(false, 4)
        )
    }
}