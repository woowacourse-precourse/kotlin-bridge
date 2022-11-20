package bridge

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class UnitTest  : NsTest() {

    @Test
    fun `이동할 칸 입력 단위 테스트`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest(
            {
                run("3", "U", "U", "U")
                Assertions.assertThat(output()).contains(
                    "3",
                    "U",
                    "U",
                    "U",
                )
            },
            listOf(1, 1, 1),
        )
    }



    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }

}