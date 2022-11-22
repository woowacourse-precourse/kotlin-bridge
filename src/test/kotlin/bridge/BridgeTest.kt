package bridge

import bridge.data.*
import bridge.domain.BridgeMaker
import bridge.domain.BridgeNumberGenerator
import bridge.domain.BridgeRandomNumberGenerator
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class BridgeTest {
    @Test
    fun `다리 - 생성 테스트`() {
        val numberGenerator: BridgeNumberGenerator = ApplicationTest.TestNumberGenerator(listOf(ZERO, ZERO, ZERO, ONE))
        val bridgeMaker = BridgeMaker(numberGenerator)
        val bridge: List<String> = bridgeMaker.makeBridge(FOUR)
        Assertions.assertThat(bridge).containsExactly(UP, DOWN, DOWN, UP)
    }

    @Test
    fun `다리 - 길이 테스트`() {
        val size = FIVE
        val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
        val bridge: List<String> = bridgeMaker.makeBridge(size)
        Assertions.assertThat(bridge).hasSize(size)
    }
}