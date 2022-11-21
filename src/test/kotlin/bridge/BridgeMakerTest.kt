package bridge

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BridgeMakerTest {

    @Test
    fun `다리생성 함수 테스트`() {
        val bridgeMaker = BridgeMaker(StubBridgeNumberGenerator(mutableListOf(0, 1, 1, 1, 0, 1)))
        assertThat(bridgeMaker.makeBridge(6)).isEqualTo(listOf("D", "U", "U", "U", "D", "U"))
    }
}
