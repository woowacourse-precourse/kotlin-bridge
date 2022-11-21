package bridge

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OutputTest : NsTest() {

    private val outputTest = OutputView()

    @Test
    fun `선택한 값이 맞을 때를 출력한다`() {
        outputTest.printMap(listOf(Pair("U", true), Pair("D", true), Pair("D", true)))
        assertThat(output()).contains(
            "[ O |   |   ]",
            "[   | O | O ]"
        )
    }

    @Test
    fun `선택한 값이 틀릴 때를 출력한다`() {
        outputTest.printMap(listOf(Pair("U", true), Pair("D", true), Pair("U", false)))
        assertThat(output()).contains(
            "[ O |   | X ]",
            "[   | O |   ]"
        )
    }

    override fun runMain() {
        main()
    }
}