package bridge.domain

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import bridge.data.InputDataSource
import bridge.domain.controller.BridgeGame
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BridgeGameTest {
    private lateinit var bridgeGame: BridgeGame

    @BeforeEach
    fun setUp() {
        InputDataSource.initDataSource()
        val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
        bridgeGame = BridgeGame(bridgeMaker)
    }

    @Test
    fun `게임을 재시도하면 총 시도 횟수가 증가하는지에 대해 테스트를 한다`() {
        bridgeGame.retry()
        Assertions.assertThat(InputDataSource).extracting("numberOfTry").isEqualTo(2)
    }
}