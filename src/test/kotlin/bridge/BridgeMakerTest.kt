package bridge

import bridge.domain.constructor.BridgeMaker
import bridge.domain.constructor.BridgeNumberGenerator
import bridge.domain.constructor.BridgeRandomNumberGenerator
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BridgeMakerTest {
    private val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())

    @Test
    fun `랜덤값 변환 테스트`() {
        assertRandomNumberInRangeTest({
            assertThat(bridgeMaker.makeBridge(4)).isEqualTo(listOf("U", "U", "D", "U"))
        }, 1, 1, 0, 1)
    }

    @Test
    fun `랜덤값 변환 테스트 - 전략 패턴`() {
        val input = listOf(0, 1, 0, 1)
        val result = listOf("D", "U", "D", "U")
        val bridgeMaker = BridgeMaker(TestBridgeNumberGenerator(input))
        val bridge = bridgeMaker.makeBridge(input.size)
        assertThat(bridge).isEqualTo(result)
    }

    @Test
    fun `만든 다리 개수 테스트`() {
        assertThat(bridgeMaker.makeBridge(4)).hasSize(4)
    }

    class TestBridgeNumberGenerator(numbers: List<Int>) : BridgeNumberGenerator {
        private val numbers: MutableList<Int> = numbers.toMutableList()
        override fun generate(): Int {
            return numbers.removeAt(0)
        }
    }
}
