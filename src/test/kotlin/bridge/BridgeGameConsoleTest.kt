package bridge

import bridge.console.BridgeGameConsole
import org.junit.jupiter.api.Test
import bridge.model.GameInfo
import org.assertj.core.api.Assertions.assertThat
import camp.nextstep.edu.missionutils.test.Assertions
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

class BridgeGameConsoleTest: NsTest() {
    @BeforeEach
    @AfterEach
    fun `enum class 게임 횟수 인자 초기화`(){
        GameInfo.GAME_TRIAL_COUNT.gameTrialCount = 0
    }

    @Test
    fun `처음 아래칸 이동에 실패한 경우`(){
        Assertions.assertRandomNumberInRangeTest({
            run("4", "D", "Q")
            assertThat(output()).contains(
                "[   ]",
                "[ X ]",
                "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                "최종 게임 결과",
                "[   ]",
                "[ X ]",
                "게임 성공 여부: 실패",
                "총 시도한 횟수: 1"
            )
            val upSideIndex = output().indexOf("[   ]")
            val downSideIndex = output().indexOf("[ X ]")
            assertThat(upSideIndex).isLessThan(downSideIndex)
        }, 1, 0, 1, 0)

    }

    @Test
    fun `네 번째에 아래칸 이동에 실패한 경우`(){
        Assertions.assertRandomNumberInRangeTest({
            run("4", "U", "D", "U", "U", "Q")
            assertThat(output()).contains(
                "[ O |   | O | X ]",
                "[   | O |   |   ]",
                "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                "최종 게임 결과",
                "[ O |   | O | X ]",
                "[   | O |   |   ]",
                "게임 성공 여부: 실패",
                "총 시도한 횟수: 1"
            )
            val upSideIndex = output().indexOf("[ O |   | O | X ]")
            val downSideIndex = output().indexOf("[   | O |   |   ]")
            assertThat(upSideIndex).isLessThan(downSideIndex)
        }, 1, 0, 1, 0)
    }

    @Test
    fun `네 번째에 아래칸 이동에 실패한 후 다시 시도하여 성공하는 경우`(){
        Assertions.assertRandomNumberInRangeTest({
            run("4", "U", "D", "U", "U", "R", "U", "D", "U", "D")
            assertThat(output()).contains(
                "[ O |   | O | X ]",
                "[   | O |   |   ]",
                "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                "최종 게임 결과",
                "[ O |   | O |   ]",
                "[   | O |   | O ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 2"
            )
            val upSideIndex = output().indexOf("[ O |   | O |   ]")
            val downSideIndex = output().indexOf("[   | O |   | O ]")
            assertThat(upSideIndex).isLessThan(downSideIndex)
        }, 1, 0, 1, 0)
    }

    override fun runMain() {
        BridgeGameConsole().startGame()
    }
}