package bridge

import bridge.domain.BlockComparator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class BlockComparatorTest {
    private val blockComparator = BlockComparator()

    @ParameterizedTest
    @CsvSource("D, O", "U, ' '")
    fun `Correct DOWN 비교 테스트`(direction: String, marking: String) {
        val result = blockComparator.compareIsDownerCorrect(direction)
        assertThat(result).isEqualTo(marking)
    }

    @ParameterizedTest
    @CsvSource("U, O", "D, ' '")
    fun `Correct UP 비교 테스트`(direction: String, marking: String) {
        val result = blockComparator.compareIsUpperCorrect(direction)
        assertThat(result).isEqualTo(marking)
    }

    @ParameterizedTest
    @CsvSource("D, X", "U, ' '")
    fun `InCorrect DOWN 비교 테스트`(direction: String, marking: String) {
        val result = blockComparator.compareIsDownerIncorrect(direction)
        assertThat(result).isEqualTo(marking)
    }

    @ParameterizedTest
    @CsvSource("U, X", "D, ' '")
    fun `InCorrect UP 비교 테스트`(direction: String, marking: String) {
        val result = blockComparator.compareIsUpperIncorrect(direction)
        assertThat(result).isEqualTo(marking)
    }
}
