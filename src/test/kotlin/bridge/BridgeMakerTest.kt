package bridge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class BridgeMakerTest {
    private val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())

    @Nested
    inner class `makeBridge 메소드는` {
        @Nested
        inner class `다리 길이를 받으면` {
            private val bridgeSize = 20

            @Test
            fun `크기는 입력 받은 길이이고 U와 D로 이루어진 리스트를 반환한다`() {
                val bridge = bridgeMaker.makeBridge(bridgeSize)

                assertThat(bridge).hasSize(bridgeSize)
                assertThat(bridge).containsOnly("U", "D")
            }
        }
    }
}