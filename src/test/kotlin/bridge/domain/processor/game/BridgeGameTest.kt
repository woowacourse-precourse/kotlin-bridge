package bridge.domain.processor.game

import bridge.domain.game.BridgeGame
import bridge.domain.generator.BridgeRandomNumberGenerator
import bridge.domain.maker.BridgeMaker
import bridge.ui.view.InputView
import bridge.ui.view.OutputView
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BridgeGameTest {
    private lateinit var bridgeGame: BridgeGame
    @BeforeEach
    fun setUp() {
        val inputView = InputView()
        val outputView = OutputView()
        val bridgeNumberGenerator = BridgeRandomNumberGenerator()

        val bridgeMaker = BridgeMaker(bridgeNumberGenerator = bridgeNumberGenerator)

        // Given
        bridgeGame = BridgeGame(inputView = inputView, outputView = outputView, bridgeMaker = bridgeMaker)
    }

    @Test
    fun `게임 재시도 한 뒤 시도 횟수 증가하는지 테스트`() {
        // When
        bridgeGame.retry()

        // Then
        Assertions.assertThat(bridgeGame).extracting("numberOfTry").isEqualTo(2)
        Assertions.assertThat(bridgeGame).extracting("round").isEqualTo(0)
    }
}