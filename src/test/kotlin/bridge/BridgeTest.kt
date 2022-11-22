package bridge

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class BridgeTest {

    @Test
    fun `다리 생성 테스트`() {
        val numberGenerator: BridgeNumberGenerator = ApplicationTest.TestNumberGenerator(listOf(1, 1, 1, 1, 0))
        val bridgeMaker = BridgeMaker(numberGenerator)
        val bridge: List<String> = bridgeMaker.makeBridge(5)
        Assertions.assertThat(bridge).containsExactly("U", "U", "U", "U", "D")
    }
}