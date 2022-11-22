package bridge

import bridge.BridgeGame.Companion.MOVING_DIRECT_DOWN
import bridge.BridgeGame.Companion.MOVING_DIRECT_UP
import org.junit.jupiter.api.Test

class BridgeMakerTest {

    private val bridgeMaker = BridgeMaker(
        bridgeNumberGenerator = BridgeRandomNumberGenerator()
    )

    @Test
    fun `입력한 길이 만큼의 다리 만들기`() {
        assert(bridgeMaker.makeBridge(3).size == 3)
    }

    @Test
    fun `U와 D로 이루어진 다리 만들기`() {
        bridgeMaker.makeBridge(100).forEach {
            assert(
                it == MOVING_DIRECT_UP || it == MOVING_DIRECT_DOWN
            )
        }
    }
}