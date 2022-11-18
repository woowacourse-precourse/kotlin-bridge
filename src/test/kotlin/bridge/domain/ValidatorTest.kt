package bridge.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.lang.IllegalArgumentException

internal class ValidatorTest {

    @ParameterizedTest
    @CsvSource("0", "1", "2", "21", "22", "23", "24", "10000")
    @DisplayName("3~20 숫자 이내의 수만 들어오는 지 확인")
    fun `다리길이_정규식_검사_실패시_예외처리`(input: String) {
        Assertions.assertThatThrownBy {
            Validator.isValidBridgeSize(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] 유효한 숫자가 아닙니다.")
    }

    @ParameterizedTest
    @CsvSource(
        "3,3", "4,4", "5,5", "6,6", "7,7", "8,8", "9,9",
        "10,10", "11,11", "12,12", "13,13", "14,14",
        "15,15", "16,16", "17,17", "18,18", "19,19", "20,20"
    )
    @DisplayName("3~20 숫자 이내의 수만 들어오는 지 확인")
    fun `다리길이_정규식_검사_성공시_확인`(input: String, result: Int) {
        Assertions.assertThat(result).isEqualTo(Validator.isValidBridgeSize(input))
    }

}
