package bridge.ui

import bridge.enums.Status
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OutputViewTest : NsTest() {
    private val outputView = OutputView()

    @Test
    fun `다리 그리기 테스트 - 성공`() {
        outputView.printMap(BRIDGE, PROGRESS_CORRECT)
        assertThat(output()).contains("[ O | O | O |   |   ]", "[   |   |   | O | O ]")
    }

    @Test
    fun `다리 그리기 테스트 - 실패`() {
        outputView.printMap(BRIDGE, PROGRESS_WRONG)
        assertThat(output()).contains("[ O | O |   ]", "[   |   | X ]")
    }

    @Test
    fun `결과 출력 테스트 - 성공`() {
        outputView.printResult(BRIDGE, PROGRESS_CORRECT, PLAY_COUNT)
        assertThat(output()).contains(
            "최종 게임 결과",
            "[ O | O | O |   |   ]",
            "[   |   |   | O | O ]",
            "게임 성공 여부: 성공",
            "총 시도한 횟수: 2"
        )
    }

    @Test
    fun `결과 출력 테스트 - 실패`() {
        outputView.printResult(BRIDGE, PROGRESS_WRONG, PLAY_COUNT)
        assertThat(output()).contains(
            "최종 게임 결과",
            "[ O | O |   ]",
            "[   |   | X ]",
            "게임 성공 여부: 실패",
            "총 시도한 횟수: 2"
        )
    }

    override fun runMain() {}

    companion object {
        private val BRIDGE = listOf<String>("U", "U", "U", "D", "D")
        private val PROGRESS_CORRECT =
            listOf<Status>(Status.CORRECT, Status.CORRECT, Status.CORRECT, Status.CORRECT, Status.CORRECT)
        private val PROGRESS_WRONG = listOf<Status>(Status.CORRECT, Status.CORRECT, Status.WRONG)
        private const val PLAY_COUNT = 2
    }
}