package bridge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class ResultTest {

    @Test
    fun `결과 값 추가 테스트`() {
        result.addResult("U", true)
        result.addResult("D", true)
        result.addResult("U", false)

        val firstRowExpected = arrayListOf<String>("O", " ", "X")
        val secondRowExpected = arrayListOf(" ", "O", " ")

        assertThat(result.getFirstRowResult()).isEqualTo(firstRowExpected)
        assertThat(result.getSecondRowResult()).isEqualTo(secondRowExpected)
    }

    companion object {

        lateinit var result: Result

        @BeforeAll
        @JvmStatic
        fun initResult() {
            result = Result()
        }
    }
}