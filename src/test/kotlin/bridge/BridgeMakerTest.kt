package bridge

import domain.BridgeMaker
import domain.BridgeNumberGenerator
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class BridgeMakerTest {
    @Test
    fun `다리 생성 테스트`() {
        val numberGenerator: BridgeNumberGenerator = ApplicationTest.TestNumberGenerator(listOf(1, 0, 0))
        val bridgeMaker = BridgeMaker(numberGenerator)
        val bridge: List<String> = bridgeMaker.makeBridge(3)
        Assertions.assertThat(bridge).containsExactly("U", "D", "D")
    }
}