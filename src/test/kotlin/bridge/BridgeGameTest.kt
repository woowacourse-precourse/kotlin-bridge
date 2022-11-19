package bridge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class BridgeGameTest {

    @ParameterizedTest
    @CsvSource("U,[ O ],[   ]", "D,[ O |   ],[   | O ]", "D,[ O |   |   ],[   | O | O ]")
    fun `다리 건너는 기능 테스트`(direction: String, up: String, down: String) {
        val bridgeMaker = listOf("U", "D", "D")
        BridgeGame().move(bridge, direction, bridgeMaker)
        assertThat("[${bridge.up}]").isEqualTo(up)
        assertThat("[${bridge.down}]").isEqualTo(down)
    }

    companion object {
        private val bridge = Bridge()
    }
}