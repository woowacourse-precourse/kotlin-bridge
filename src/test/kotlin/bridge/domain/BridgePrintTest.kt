package bridge.domain

import bridge.BridgeGame
import bridge.view.OutputView
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class BridgePrintTest {
    @Test
    fun `끝까지 출력`() {
        val bridge = listOf<String>("U", "D", "D", "D", "U")
        val answer = true

        OutputView().printMap(bridge, answer)
    }

    @Test
    fun `3번째 라인까지 출력`() {
        val location = 2
        val bridge = listOf<String>("U", "D", "D", "D")
        val game = BridgeGame(bridge, bridge.size)
        val newBridge = game.move(location)
        val answer = true

        OutputView().printMap(newBridge, answer)
    }

    @Test
    fun `도중에 틀릴 경우`() {
        val location = 1
        val bridge = listOf<String>("U", "D", "D")
        val game = BridgeGame(bridge, bridge.size)
        val newBridge = game.move(location)
        val answer = false

        OutputView().printMap(newBridge, answer)
    }

    @Test
    fun `최종 결과 출력`() {
        val tryCount = 2
        val bridge = listOf<String>("U", "D", "D")
        val answer = false

        OutputView().printResult(bridge, answer, tryCount)
    }

    @Test
    fun `게임 성공 여부 출력`() {
        val bridge = listOf<String>("U", "D", "D")

        OutputView().printResult(bridge, true, 3)
        OutputView().printResult(bridge, false, 4)
    }
}