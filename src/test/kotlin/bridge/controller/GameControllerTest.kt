package bridge.controller

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class GameControllerTest :NsTest(){
    private val gameController = GameController()
    @Test
    fun `다리 길이 5 기능 테스트`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest({
            run("5", "U", "D", "U", "U","D")
            Assertions.assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O | O |   ]",
                    "[   | O |   |   | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1"
            )
            val upSideIndex = output().indexOf("[ O |   | O | O |   ]")
            val downSideIndex = output().indexOf("[   | O |   |   | O ]")
            Assertions.assertThat(upSideIndex).isLessThan(downSideIndex)
        }, 1, 0, 1,1,0)
    }

    @Test
    fun `다리 길이 3 재시도 테스트`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest({
            run("3", "D", "R", "U", "D","U")
            Assertions.assertThat(output()).contains(
                    "[ X ]",
                    "[   ]",
                    "최종 게임 결과",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            )
            val upSideIndex = output().indexOf("[ O |   | O ]")
            val downSideIndex = output().indexOf("[   | O |   ]")
            Assertions.assertThat(upSideIndex).isLessThan(downSideIndex)
        }, 1, 0, 1)
    }

    @Test
    fun `다리 길이 3 실패 후 종료 테스트`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest({
            run("3", "U", "D", "D", "Q")
            Assertions.assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   |   ]",
                    "[   | O | X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            )
            val upSideIndex = output().indexOf("[ O |   | O ]")
            val downSideIndex = output().indexOf("[   | O |   ]")
            Assertions.assertThat(upSideIndex).isLessThan(downSideIndex)
        }, 1, 0, 1)
    }

    override fun runMain() {
        gameController.playGame()
    }

}