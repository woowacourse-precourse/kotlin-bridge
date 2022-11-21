package bridge.domain

import bridge.BridgeGame
import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class BridgeGameTest {

    @Test
    fun `정답 체크`() {
        val size = 10
        val bridge = listOf<String>("U", "U", "D")
        val game = BridgeGame(bridge, size)
    }
}