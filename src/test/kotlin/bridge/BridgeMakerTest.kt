package bridge

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class BridgeMakerTest {

    @Test
    fun `기능테스트(makeBridge)`() {
        val numberGenerator: BridgeNumberGenerator = ApplicationTest.TestNumberGenerator(listOf(1, 0, 0))
        val bridgeMaker = BridgeMaker(numberGenerator)
        val bridge: List<String> = bridgeMaker.makeBridge(3)
        Assertions.assertThat(bridge).containsExactly("U", "D", "D")
    }
}