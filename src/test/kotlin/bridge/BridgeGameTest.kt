package bridge

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class BridgeGameTest {
    @Test
    fun `다리의 끝까지 이동한 경우 게임이 종료된다`() {
        val bridgeMaker = BridgeMaker(TestNumberGenerator(listOf(1, 1, 0))).makeBridge(3)
        val bridgeGame = BridgeGame()

        println(bridgeMaker)
        bridgeGame.move(bridgeMaker[0], "U")
        bridgeGame.move(bridgeMaker[1], "U")
        bridgeGame.move(bridgeMaker[2], "D")
        assertThat(bridgeGame.isGameEnd(bridgeMaker)).isEqualTo(true)
    }

    @Test
    fun `마지막 다리에서 실패하더라도 게임이 종료된다`() {
        val bridgeMaker = BridgeMaker(TestNumberGenerator(listOf(1, 1, 0))).makeBridge(3)
        val bridgeGame = BridgeGame()

        bridgeGame.move(bridgeMaker[0], "U")
        bridgeGame.move(bridgeMaker[1], "U")
        bridgeGame.move(bridgeMaker[2], "U")
        assertThat(bridgeGame.isGameEnd(bridgeMaker)).isEqualTo(true)
    }

    class TestNumberGenerator(numbers: List<Int>) : BridgeNumberGenerator {
        private val numbers: MutableList<Int> = numbers.toMutableList()

        override fun generate(): Int {
            return numbers.removeAt(0)
        }
    }
}