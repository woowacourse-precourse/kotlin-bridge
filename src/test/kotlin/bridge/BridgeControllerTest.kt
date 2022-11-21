package bridge

import bridge.controller.BridgeController
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BridgeControllerTest : NsTest() {

    @Test
    fun `다리 길이 잘못 입력 후 재입력`() {
        assertRandomNumberInRangeTest({
            run("1", "", "U", "3", "U", "D", "D")
            assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   |   ]",
                "[   | O | O ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 1"
            )
            val upSideIndex = output().indexOf("[ O |   |   ]")
            val downSideIndex = output().indexOf("[   | O | O ]")
            assertThat(upSideIndex).isLessThan(downSideIndex)
        }, 1, 0, 0)
    }

    @Test
    fun `다리 이동 잘못 입력 후 재입력`() {
        assertRandomNumberInRangeTest({
            run("3", "", "u", "3", "U", "D", "D")
            assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   |   ]",
                "[   | O | O ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 1"
            )
            val upSideIndex = output().indexOf("[ O |   |   ]")
            val downSideIndex = output().indexOf("[   | O | O ]")
            assertThat(upSideIndex).isLessThan(downSideIndex)
        }, 1, 0, 0)
    }
    override fun runMain() {
        BridgeController().start()
    }
}