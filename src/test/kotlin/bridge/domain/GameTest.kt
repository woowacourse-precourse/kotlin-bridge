package bridge.domain

import bridge.ApplicationTest
import bridge.BridgeMaker
import bridge.BridgeNumberGenerator
import bridge.BridgeRandomNumberGenerator
import bridge.data.*
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class GameTest {
    private val bridgeGame = BridgeGame()

    @Test
    fun `게임시작 - 브릿지 생성 테스트`() {
        val numberGenerator: BridgeNumberGenerator = ApplicationTest.TestNumberGenerator(listOf(ZERO, ZERO, ZERO, ONE))
        val bridgeMaker = BridgeMaker(numberGenerator)
        val bridge: List<String> = bridgeMaker.makeBridge(FOUR)
        Assertions.assertThat(bridge).containsExactly(DOWN, DOWN, DOWN, UP)
    }

    @Test
    fun `게임시작 - 브릿지 길이 테스트`() {
        val size = FIVE
        val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
        val bridge: List<String> = bridgeMaker.makeBridge(size)
        Assertions.assertThat(bridge).hasSize(size)
    }

}