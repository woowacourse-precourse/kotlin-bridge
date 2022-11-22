package bridge.domain

import bridge.BridgeRandomNumberGenerator
import bridge.view.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BridgeGameTest {
    private lateinit var bridgeGame: BridgeGame

    @BeforeEach
    fun set() {
        val gameManager = BridgeGameManager(InputView(), OutputView())
        val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())

        bridgeGame = BridgeGame(gameManager, bridgeMaker)
    }

    @Test
    fun getMapTest() {
        bridgeGame.bridge = listOf("U", "D", "D")
        bridgeGame.path = mutableListOf("U", "D", "U")
        val result = listOf(
            listOf("O", " ", "X"),
            listOf(" ", "O", " ")
        )
        assertThat(bridgeGame.getMap()).isEqualTo(result)
    }
}