package bridge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BridgeGameTest {
    @Test
    fun `종료 테스트1`() {
        val bridgeGame = BridgeGame()
        val numberGenerator: BridgeNumberGenerator = ApplicationTest.TestNumberGenerator(listOf(1, 0, 1))
        val bridgeMaker = BridgeMaker(numberGenerator)
        val bridge: List<String> = bridgeMaker.makeBridge(3)
        bridgeGame.move("U")
        bridgeGame.move("D")
        bridgeGame.move("U")
        val result = bridgeGame.isFail(bridge)

        assertThat(result).isEqualTo(false)
    }

    @Test
    fun `종료 테스트2`() {
        val bridgeGame = BridgeGame()
        val numberGenerator: BridgeNumberGenerator = ApplicationTest.TestNumberGenerator(listOf(1, 1, 1))
        val bridgeMaker = BridgeMaker(numberGenerator)
        val bridge: List<String> = bridgeMaker.makeBridge(3)
        bridgeGame.move("U")
        bridgeGame.move("U")
        bridgeGame.move("U")
        val result = bridgeGame.isFail(bridge)

        assertThat(result).isEqualTo(false)
    }

    @Test
    fun `종료 테스트3`() {
        val bridgeGame = BridgeGame()
        val numberGenerator: BridgeNumberGenerator = ApplicationTest.TestNumberGenerator(listOf(1, 1, 1))
        val bridgeMaker = BridgeMaker(numberGenerator)
        val bridge: List<String> = bridgeMaker.makeBridge(3)
        bridgeGame.move("U")
        bridgeGame.move("D")
        bridgeGame.move("U")
        val result = bridgeGame.isFail(bridge)

        assertThat(result).isEqualTo(true)
    }
}