package bridge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BridgeTest {
    val numberGenerator: BridgeNumberGenerator = ApplicationTest.TestNumberGenerator(listOf(1, 0, 0))
    val bridgeMaker = BridgeMaker(numberGenerator)
    val bridge: List<String> = bridgeMaker.makeBridge(3)

    @Test
    fun `다리 생성 테스트`() {

        assertThat(bridge).containsExactly("U", "D", "D")
    }

    @Test
    fun `다리를 건널 수 있다`() {
        assertThat(BridgeGame().bridgUp("U","U")).isEqualTo(" O ")
        assertThat(BridgeGame().bridgDown("U","U")).isEqualTo("   ")
    }

    @Test
    fun `다리를 건널 수 없다`() {
        assertThat(BridgeGame().bridgUp("D","U")).isEqualTo(" X ")
        assertThat(BridgeGame().bridgDown("D","U")).isEqualTo("   ")
    }


}