package bridge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class JudgementTest {
    @ParameterizedTest
    @CsvSource("U,U,O", "D,D,O", "U,D,X", "D,U,X")
    fun `다리 방향이 일치 확인 테스트`(playerDirection: String, computerDirection: String, expected: String) {
        val actual = Judgement().compareDirection(playerDirection, computerDirection)
        assertThat(actual).isEqualTo(expected)
    }
}