package bridge

import bridge.controller.BridgeController
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BridgeControllerTest : NsTest() {
    @Test
    fun `다리 길이, 다리 이동, 게임 재시작 여부 재입력 테스트`() {
        assertRandomNumberInRangeTest({
            run("1", "", "U", "3", "1", "", "u", "U", "D", "U", "", "r", "1", "R", "U", "D", "D")
            assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   |   ]",
                "[   | O | O ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 2"
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