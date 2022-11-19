package bridge

import bridge.validator.BridgeGameValidator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class BridgeGameTest {

    @ParameterizedTest
    @CsvSource(
        "1, true, 0",
        "0, false, 0"
    )
    fun `라운드 이동 기능 테스트`(nextRound: Int, isMatched: Boolean, currentRound: Int) {
        assertThat(nextRound).isEqualTo(BridgeGameValidator.validateMoveOutput(isMatched, currentRound))
    }
}