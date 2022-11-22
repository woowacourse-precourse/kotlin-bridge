package bridge

import bridge.domain.usecase.BridgeGame
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class BridgeGameTest {
    @Test
    fun `move 테스트`() {
        val bridgeRow ="U"
        val userInputRow ="D"
        val move = BridgeGame().move(bridgeRow,userInputRow).first
        Assertions.assertThat(move).isEqualTo(" ")
    }


}