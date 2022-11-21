package bridge

import bridge.view.validator.BridgeGameValidator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class BridgeGameTest {

    @ParameterizedTest
    @CsvSource(
        "1, true",
        "0, false"
    )
    fun `라운드 이동 기능 테스트`(nextRound: Int, isMatched: Boolean) {
        assertThat(nextRound).isEqualTo(BridgeGameValidator.validateMoveOutput(isMatched))
    }
}