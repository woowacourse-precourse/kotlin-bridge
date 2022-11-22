package bridge.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BridgeMakerTest {
    lateinit var bridgeMaker: BridgeMaker

    @BeforeEach
    fun setUp() {
        bridgeMaker = BridgeMaker(TestNumberGenerator(listOf(1, 0, 0)))
    }

    @Test
    fun `정답 다리가 잘 생성되는 지 확인`() {
        val bridge = bridgeMaker.makeBridge(3)
        assertThat(bridge).containsExactly("U", "D", "D")
    }

    @Test
    fun `정답다리에 맞추어 위의 다리가 반환되는지 확인`() {
        val answerBridge = bridgeMaker.makeBridge(3)
        val upBridge = bridgeMaker.makeCompletedBridge(answerBridge, isUpBridge = true)
        assertThat(upBridge).containsExactly("O", " ", " ")
    }

    @Test
    fun `정답다리에 맞추어 아래의 다리가 반환되는지 확인`() {
        val answerBridge = bridgeMaker.makeBridge(3)
        val downBridge = bridgeMaker.makeCompletedBridge(answerBridge, isUpBridge = false)
        assertThat(downBridge).containsExactly(" ", "O", "O")
    }

    class TestNumberGenerator(numbers: List<Int>) : BridgeNumberGenerator {
        private val numbers: MutableList<Int> = numbers.toMutableList()

        override fun generate(): Int {
            return numbers.removeAt(0)
        }
    }

}