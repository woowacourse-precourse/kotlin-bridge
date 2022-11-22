package bridge

import bridge.domain.BridgeGame
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BridgeGameTest {
    @Test
    fun `다리를 끝까지 건너면 게임이 종료된다`() {
        val numberGenerator: BridgeNumberGenerator = TestNumberGenerator(listOf(1, 0, 0))
        val bridgeMaker = BridgeMaker(numberGenerator)
        val bridge: List<String> = bridgeMaker.makeBridge(3)
        val bridgeGame = BridgeGame(bridge)

        bridgeGame.move("U")
        bridgeGame.move("U")
        bridgeGame.move("D")
        assertThat(bridgeGame.endGame()).isEqualTo(true)
    }

    @Test
    fun `다리를 건너다 실패하면 게임이 끝난다`() {
        val numberGenerator: BridgeNumberGenerator = TestNumberGenerator(listOf(1, 0, 0))
        val bridgeMaker = BridgeMaker(numberGenerator)
        val bridge: List<String> = bridgeMaker.makeBridge(3)
        val bridgeGame = BridgeGame(bridge)

        bridgeGame.move("U")
        bridgeGame.move("U")
        assertThat(bridgeGame.endGame()).isEqualTo(false)
    }

    @Test
    fun `게임을 재시작하면 변수가 초기화 된다`() {
        val numberGenerator: BridgeNumberGenerator = TestNumberGenerator(listOf(1, 0, 0))
        val bridgeMaker = BridgeMaker(numberGenerator)
        val bridge: List<String> = bridgeMaker.makeBridge(3)
        val bridgeGame = BridgeGame(bridge)
        var emptyList: MutableList<String> = mutableListOf<String>()
        bridgeGame.move("U")
        bridgeGame.move("U")
        bridgeGame.retry()

        assertThat(bridgeGame.downCase).isEqualTo(emptyList)
        assertThat(bridgeGame.upCase).isEqualTo(emptyList)
    }

    @Test
    fun `게임을 재시작하면 시도한 횟수가 증가한다`() {
        val numberGenerator: BridgeNumberGenerator = TestNumberGenerator(listOf(1, 0, 0))
        val bridgeMaker = BridgeMaker(numberGenerator)
        val bridge: List<String> = bridgeMaker.makeBridge(3)
        val bridgeGame = BridgeGame(bridge)
        bridgeGame.move("U")
        bridgeGame.move("U")
        bridgeGame.retry()

        assertThat(bridgeGame.getTotalCount()).isEqualTo(2)
    }
}

class TestNumberGenerator(numbers: List<Int>) : BridgeNumberGenerator {
    private val numbers: MutableList<Int> = numbers.toMutableList()

    override fun generate(): Int {
        return numbers.removeAt(0)
    }
}