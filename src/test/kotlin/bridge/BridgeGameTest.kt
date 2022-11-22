package bridge

import bridge.domain.BridgeGame
import bridge.domain.Bridge
import bridge.domain.Player
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

    @ParameterizedTest
    @CsvSource("true,성공", "false,실패")
    fun `게임 성공 여부 기능 테스트`(isSuccess: Boolean, expected: String) {
        player.isGameSuccess = isSuccess
        val actual = BridgeGame().isSuccess(player)
        assertThat(actual).isEqualTo(expected)
    }

    companion object {
        private val bridge = Bridge()
        private val player = Player()
    }
}