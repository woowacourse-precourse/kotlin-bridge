package bridge.domain

import bridge.BridgeNumberGenerator
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

    class TestNumberGenerator(numbers: List<Int>) : BridgeNumberGenerator {
        private val numbers: MutableList<Int> = numbers.toMutableList()

        override fun generate(): Int {
            return numbers.removeAt(0)
        }
    }

}