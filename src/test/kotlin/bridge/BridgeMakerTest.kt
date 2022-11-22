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

    @Test
    @DisplayName("위쪽 다리가 U또는 공백,아래쪽 다리가 D또는 공백을 포함하는지 테스트한다.")
    fun makeUDBridge() {
        val bridgeLine = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(3)
        val bridge: List<List<String>> = listOf(
            bridgeLine.map { it.replace("D", " ") },
            bridgeLine.map { it.replace("U", " ") }
        )
        assertThat(bridge[0]).containsAnyOf("U", " ")
        assertThat(bridge[1]).containsAnyOf("D", " ")
    }
}
