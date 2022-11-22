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

    @Test
    fun `최종 결과 성공 출력`() {
        order = 2
        BridgeGame.upBridge = mutableListOf("O", " ", "O")
        BridgeGame.downBridge = mutableListOf(" ", "O", " ")
        assertSimpleTest {
            OutputView().printResult(true)
            assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   | O ]",
                "[   | O |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 1"
            )
        }
    }

    @Test
    fun `최종 결과 실패 출력`() {
        order = 1
        BridgeGame.upBridge = mutableListOf("O", " ")
        BridgeGame.downBridge = mutableListOf(" ", "X")
        assertSimpleTest {
            OutputView().printResult(false)
            assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   ]",
                "[   | X ]",
                "게임 성공 여부: 실패",
                "총 시도한 횟수: 1"
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