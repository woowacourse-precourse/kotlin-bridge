package bridge.domain

import bridge.*
import bridge.resources.START_TRY
import org.junit.jupiter.api.Test

class BridgeGameTest {
    @Test
    fun `정상적인 범주의 값이 나온다`() {
        val size = 10
        val numberGenerator: BridgeNumberGenerator = ApplicationTest.TestNumberGenerator(listOf(1, 0, 0))
        val bridgeGame = BridgeMaker(numberGenerator).makeBridge(size)

        BridgeGame(bridgeGame, START_TRY).move(size - 1)

    }
}