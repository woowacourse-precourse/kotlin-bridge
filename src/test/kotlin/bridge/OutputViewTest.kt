package bridge

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OutputViewTest : NsTest() {
    @Test
    fun `현재 다리 출력`() {
        order = 1
        BridgeGame.upBridge = mutableListOf("O", " ")
        BridgeGame.downBridge = mutableListOf(" ", "O")
        assertSimpleTest {
            OutputView().printMap()
            assertThat(output()).contains(
                "[ O |   ]",
                "[   | O ]"
            )
        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}