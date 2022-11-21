package bridge

import bridge.domain.BlockComparator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ComparatorTest {
    private val blockComparator = BlockComparator()

    @Test
    fun `Correct DOWN 일치 비교 테스트`() {
        val result = blockComparator.compareIsDownerCorrect("D")
        assertThat(result).isEqualTo("O")
    }

    @Test
    fun `Correct UP 일치 비교 테스트`() {
        val result = blockComparator.compareIsUpperCorrect("U")
        assertThat(result).isEqualTo("O")
    }

    @Test
    fun `Correct DOWN 불일치 비교 테스트`() {
        val result = blockComparator.compareIsDownerCorrect("U")
        assertThat(result).isEqualTo(" ")
    }

    @Test
    fun `Correct UP 불일치 비교 테스트`() {
        val result = blockComparator.compareIsUpperCorrect("D")
        assertThat(result).isEqualTo(" ")
    }

    @Test
    fun `Incorrect DOWN 일치 비교테스트`() {
        val result = blockComparator.compareIsDownerIncorrect("D")
        assertThat(result).isEqualTo("X")
    }

    @Test
    fun `Incorrect UP 일치 비교테스트`() {
        val result = blockComparator.compareIsUpperIncorrect("U")
        assertThat(result).isEqualTo("X")
    }

    @Test
    fun `Incorrect DOWN 불일치 비교테스트`() {
        val result = blockComparator.compareIsDownerIncorrect("U")
        assertThat(result).isEqualTo(" ")
    }

    @Test
    fun `Incorrect UP 불일치 비교테스트`() {
        val result = blockComparator.compareIsUpperIncorrect("D")
        assertThat(result).isEqualTo(" ")
    }
}
