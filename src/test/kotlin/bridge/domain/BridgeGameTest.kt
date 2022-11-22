package bridge.domain

import bridge.ApplicationTest
import bridge.BridgeNumberGenerator
import bridge.BridgeRandomNumberGenerator
import bridge.view.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BridgeGameTest {
    private lateinit var bridgeGame: BridgeGame

    @BeforeEach
    fun set() {
        val gameManager = BridgeGameManager(InputView(), OutputView())
        val numberGenerator: BridgeNumberGenerator = ApplicationTest.TestNumberGenerator(listOf(1, 0, 0))
        val bridgeMaker = BridgeMaker(numberGenerator)

        bridgeGame = BridgeGame(gameManager, bridgeMaker)
        bridgeGame.setBridge(3)
    }

    @Test
    fun getMapTest() {
        bridgeGame.resetValues()
        bridgeGame.updateMovingPath("U")
        bridgeGame.updateMovingPath("D")
        bridgeGame.updateMovingPath("U")

        val result = listOf(
            listOf("O", " ", "X"),
            listOf(" ", "O", " ")
        )
        assertThat(bridgeGame.getMap()).isEqualTo(result)
    }

    @Test
    fun `이동값에 따른 성공여부 판단 테스트`() {
        assertThat(bridgeGame.isSuccessMoving("U", 0)).isTrue
        assertThat(bridgeGame.isSuccessMoving("U", 1)).isFalse
    }
}