package bridge

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BridgeMakerTest {

    @Test
    fun `다리생성 함수 테스트 1`() {
        val bridgeMaker = BridgeMaker(StubBridgeNumberGenerator(mutableListOf(0, 1, 1, 1, 0, 1)))
        assertThat(bridgeMaker.makeBridge(6)).isEqualTo(listOf("D", "U", "U", "U", "D", "U"))
    }

    @Test
    fun `다리생성 함수 테스트 2`() {
        val bridgeMaker = BridgeMaker(StubBridgeNumberGenerator(mutableListOf(0, 0, 1, 0, 0, 1, 1, 0)))
        assertThat(bridgeMaker.makeBridge(8)).isEqualTo(listOf("D", "D", "U", "D", "D", "U", "U", "D"))
    }

    @Test
    fun `다리생성 함수 테스트 3`() {
        val bridgeMaker = BridgeMaker(StubBridgeNumberGenerator(mutableListOf(1, 0, 1)))
        assertThat(bridgeMaker.makeBridge(3)).isEqualTo(listOf("U", "D", "U"))
    }
}
