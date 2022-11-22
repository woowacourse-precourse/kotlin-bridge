package bridge.domain

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class BridgeMakerTest {
    @ValueSource(ints = [3, 5, 7])
    @ParameterizedTest
    fun `입력받은 값을 길이로 하는 다리를 만든다`(bridgeSize: Int) {
        val test = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize)
        assertThat(test.size).isEqualTo(bridgeSize)
    }

    @Test
    fun `위 칸을 건널 수 있는 경우 U, 아래 칸을 건널 수 있는 경우 D 값으로 리스트를 만든다`() {
        val test = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(3)
        assertThat(test).containsAnyOf("U", "D")
    }
}