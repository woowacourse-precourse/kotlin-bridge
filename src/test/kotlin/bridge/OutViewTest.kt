package bridge

import bridge.validator.OutputValidator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class OutViewTest {
    private val bridge = listOf("U","D","D")

    @ParameterizedTest
    @CsvSource(
        "[ O ],[   ], 0, U",
        "[   ],[ X ], 0, D"
    )
    fun `첫번째 라운드 올바른 출력 테스트`(upPrint: String, downPrint: String, round: Int, direction: String) {
        assertThat(upPrint + "\n" + downPrint).isEqualTo(OutputValidator.validatePrintMap(bridge, round, direction))
    }
}