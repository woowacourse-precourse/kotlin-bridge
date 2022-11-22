package bridge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class BridgeMakerTest {

    @Test
    @DisplayName("다리가 사이즈가 정확히 만들어지는지 테스트한다.")
    fun makeCorrectBridgeSize() {
        val bridgeLine = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(3)
        assertThat(bridgeLine.size).isEqualTo(3)
    }
}
