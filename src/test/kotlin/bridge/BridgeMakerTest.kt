package bridge

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class BridgeMakerTest {

    @Test
    fun `유효한 다리 생성 테스트`() {
        val bridgeMaker = BridgeMaker(ApplicationTest.TestNumberGenerator(listOf(1, 1, 1, 1, 0)))
        val bridge: List<String> = bridgeMaker.makeBridge(5)
        Assertions.assertThat(bridge).containsExactly("U", "U", "U", "U", "D")
    }

}