package bridge.domain

import bridge.ApplicationTest
import bridge.BridgeNumberGenerator
import bridge.BridgeRandomNumberGenerator
import bridge.resources.BRIDGE_BOTTOM_LINE_CHAR
import bridge.resources.BRIDGE_TOP_LINE_CHAR
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class BridgeMakerTest {
    private val bridgeMaker = BridgeMaker(
        bridgeNumberGenerator = BridgeRandomNumberGenerator()
    )

    @Test
    fun `다리 생성 테스트 1, 입력 길이대로 다리 생성`() {
        assert(bridgeMaker.makeBridge(3).size == 3)
    }

    @Test
    fun `다리 생성 테스트 2, U 및 D로만 이루어진 다리 생성`() {
        bridgeMaker.makeBridge(100).forEach {
            assert(
                it == BRIDGE_TOP_LINE_CHAR || it == BRIDGE_BOTTOM_LINE_CHAR
            )
        }
    }

    @Test
    fun `다리 생성 테스트 3, 정상적 다리 생성`() {
        val numberGenerator: BridgeNumberGenerator = ApplicationTest.TestNumberGenerator(listOf(1, 0, 0))
        val bridgeMaker = BridgeMaker(numberGenerator)
        val bridge: List<String> = bridgeMaker.makeBridge(3)
        Assertions.assertThat(bridge).containsExactly("U", "D", "D")
    }
}