package bridge

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BridgeGameTest : NsTest() {
    @Test
    fun `move true 테스트`() {
        val numberGenerator: BridgeNumberGenerator = TestNumberGenerator(listOf(1, 0, 0))
        val bridgeMaker = BridgeMaker(numberGenerator)
        val bridge: List<String> = bridgeMaker.makeBridge(3)
        val bridgeGame = BridgeGame(bridge)
        assertThat(bridgeGame.move("U")).isEqualTo(true)
    }

    @Test
    fun `move false 테스트`() {
        val numberGenerator: BridgeNumberGenerator = TestNumberGenerator(listOf(1, 0, 0))
        val bridgeMaker = BridgeMaker(numberGenerator)
        val bridge: List<String> = bridgeMaker.makeBridge(3)
        val bridgeGame = BridgeGame(bridge)
        bridgeGame.move("U")
        assertThat(bridgeGame.move("U")).isEqualTo(false)
    }

    @Test
    fun `retry 테스트`() {
        val numberGenerator: BridgeNumberGenerator = TestNumberGenerator(listOf(1, 0, 0))
        val bridgeMaker = BridgeMaker(numberGenerator)
        val bridge: List<String> = bridgeMaker.makeBridge(3)
        val bridgeGame = BridgeGame(bridge)
        bridgeGame.move("U")
        bridgeGame.move("U")
        bridgeGame.retry()
        assertThat(bridgeGame.getTryNumber() == 2 && bridgeGame.getRoute().isEmpty()).isEqualTo(true)
    }

    @Test
    fun `isEnd true 테스트`() {
        val numberGenerator: BridgeNumberGenerator = TestNumberGenerator(listOf(1, 0, 0))
        val bridgeMaker = BridgeMaker(numberGenerator)
        val bridge: List<String> = bridgeMaker.makeBridge(3)
        val bridgeGame = BridgeGame(bridge)
        bridgeGame.move("U")
        bridgeGame.move("D")
        bridgeGame.move("D")
        assertThat(bridgeGame.isEnd()).isEqualTo(true)
    }

    @Test
    fun `isEnd false 테스트`() {
        val numberGenerator: BridgeNumberGenerator = TestNumberGenerator(listOf(1, 0, 0))
        val bridgeMaker = BridgeMaker(numberGenerator)
        val bridge: List<String> = bridgeMaker.makeBridge(3)
        val bridgeGame = BridgeGame(bridge)
        bridgeGame.move("U")
        bridgeGame.move("D")
        assertThat(bridgeGame.isEnd()).isEqualTo(false)
    }

    override fun runMain() {
        main()
    }

    class TestNumberGenerator(numbers: List<Int>) : BridgeNumberGenerator {
        private val numbers: MutableList<Int> = numbers.toMutableList()

        override fun generate(): Int {
            return numbers.removeAt(0)
        }
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}
