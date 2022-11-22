package bridge

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class BridgeTest {

    @Test
    fun `다리 생성 테스트`() {
        val numberGenerator: BridgeNumberGenerator = ApplicationTest.TestNumberGenerator(listOf(1, 1, 1, 1, 0))
        val bridgeMaker = BridgeMaker(numberGenerator)
        val bridge: List<String> = bridgeMaker.makeBridge(5)
        Assertions.assertThat(bridge).containsExactly("U", "U", "U", "U", "D")
    }

    @Test
    fun `플레이어의 입력과 다리 정보가 맞으면 O를 리턴한다`() {
        val player = "D"
        val bridge = "D"
        Assertions.assertThat(BridgeGame().move(player, bridge)).isEqualTo("O")
    }

    @Test
    fun `플레이어의 입력과 다리 정보가 다르면 X를 리턴한다`() {
        val player = "D"
        val bridge = "U"
        Assertions.assertThat(BridgeGame().move(player, bridge)).isEqualTo("X")
    }
}