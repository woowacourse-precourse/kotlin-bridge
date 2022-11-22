package bridge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import output.RandomNumber

internal class BridgeMakerTest {
    @Test
    fun `1은 U로 0은 D로 저장된다`() {
        val bridge = mutableListOf<String>()
        val bridgeInt = listOf(1, 0, 0, 1, 1)
        bridgeInt.forEach {
            if (it == RandomNumber.UP.randomNumber) {
                bridge.add(RandomNumber.UP.upDown)
            } else {
                bridge.add(RandomNumber.DOWN.upDown)
            }
        }
        assertThat(bridge).isEqualTo(listOf("U", "D", "D", "U", "U"))
    }
}