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
    @Test
    fun `retry 테스트`() {
        val upRowsResult =""
        val downRowsResult =""
        val userInputGameCommand ="Q"
        val retry = BridgeGame().retry(upRowsResult,downRowsResult,userInputGameCommand)
        Assertions.assertThat(retry.loop).isEqualTo(false)
    }
}