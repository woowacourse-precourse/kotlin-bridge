package bridge.controller

import bridge.util.constant.GAME_RETRY_QUESTION_MESSAGE
import camp.nextstep.edu.missionutils.test.Assertions
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource


class BridgeGameControllerTest : NsTest() {
    lateinit var bridgeGameController: BridgeGameController

    @BeforeEach
    fun setUp() {
        bridgeGameController = BridgeGameController()
    }

    @DisplayName("다리 길이의 범위가 초과한 경우")
    @ParameterizedTest
    @ValueSource(strings = ["-1", "0", "1", "2", "21", "100"])
    fun `다리 길이 범위를 초과하면 예외가 발생한다`(bridgeSize: String) {
        assertSimpleTest {
            runException(bridgeSize)
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @DisplayName("다리 길이가 숫자가 아닌 경우")
    @ParameterizedTest
    @ValueSource(strings = ["a", "b", "c", "ab", " ", "abc"])
    fun `다리 길이가 숫자가 아니면 예외가 발생한다`(bridgeSize: String) {
        assertSimpleTest {
            runException(bridgeSize)
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `한 번 실패하고 종료하는 경우`() {
        Assertions.assertRandomNumberInRangeTest({
            run("3", "U", "Q")
            assertThat(output()).contains(
                GAME_RETRY_QUESTION_MESSAGE,
                "[ X ]",
                "[   ]",
                "게임 성공 여부: 실패",
                "총 시도한 횟수: 1"
            )
            val upSideIndex = output().indexOf("[ X ]")
            val downSideIndex = output().indexOf("[   ]")
            assertThat(upSideIndex).isLessThan(downSideIndex)
        }, 0, 1, 0)
    }

    @Test
    fun `한 번 재시도해서 성공하는 경우`() {
        Assertions.assertRandomNumberInRangeTest({
            run("3", "U", "U", "R", "U", "D", "U")
            assertThat(output()).contains(
                GAME_RETRY_QUESTION_MESSAGE,
                "[ O | X ]",
                "[   |   ]",
                "[ O |   | O ]",
                "[   | O |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 2"
            )
            val upSideIndex = output().indexOf("[ O |   | O ]")
            val downSideIndex = output().indexOf("[   | O |   ]")
            assertThat(upSideIndex).isLessThan(downSideIndex)
        }, 1, 0, 1)
    }

    @Test
    fun `두 번 재시도해서 성공하는 경우`() {
        Assertions.assertRandomNumberInRangeTest({
            run("3", "D", "R", "U", "D", "R", "U", "U", "U")
            assertThat(output()).contains(
                GAME_RETRY_QUESTION_MESSAGE,
                "[   ]",
                "[ X ]",
                "[ O |   ]",
                "[   | X ]",
                "[ O | O | O ]",
                "[   |   |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 3"
            )
            val upSideIndex = output().indexOf("[ O | O | O ]")
            val downSideIndex = output().indexOf("[   |   |   ]")
            assertThat(upSideIndex).isLessThan(downSideIndex)
        }, 1, 1, 1)
    }

    override fun runMain() {
        bridgeGameController.startGame()
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}