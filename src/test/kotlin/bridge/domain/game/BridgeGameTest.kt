package bridge.domain.game

import bridge.BridgeRandomNumberGenerator
import bridge.BridgeMaker
import bridge.domain.mediator.BridgeGameViewMediator
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
        val bridgeGameViewMediator = BridgeGameViewMediator(inputView = inputView, outputView = outputView)

        val bridgeNumberGenerator = BridgeRandomNumberGenerator()
        val bridgeMaker = BridgeMaker(bridgeNumberGenerator = bridgeNumberGenerator)

        // Given
        bridgeGame = BridgeGame(bridgeGameViewMediator = bridgeGameViewMediator, bridgeMaker = bridgeMaker)
    }

    @Test
    fun `게임 재시도 한 뒤 시도 횟수 증가하는지 테스트`() {
        // When
        bridgeGame.retry()

        // Then
        Assertions.assertThat(bridgeGame).extracting("numberOfTry").isEqualTo(2)
        Assertions.assertThat(bridgeGame).extracting("position").isEqualTo(0)
    }
}