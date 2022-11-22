package bridge

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BridgeGameTest : NsTest() {
    @Test
    fun `다리 완주 성공 테스트`() {
        assertRandomNumberInRangeTest({
            run("3", "D", "U", "D")
            assertThat(output()).contains(
                "최종 게임 결과",
                "[   | O |   ]",
                "[ O |   | O ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 1"
            )
            val upSideIndex = output().indexOf("[   | O |   ]")
            val downSideIndex = output().indexOf("[ O |   | O ]")
            assertThat(upSideIndex).isLessThan(downSideIndex)
        }, 0, 1, 0)
    }

    @Test
    fun `다리 완주 실패 테스트`() {
        assertRandomNumberInRangeTest({
            run("3", "D", "U", "U", "Q")
            assertThat(output()).contains(
                "최종 게임 결과",
                "[   | O | X ]",
                "[ O |   |   ]",
                "게임 성공 여부: 실패",
                "총 시도한 횟수: 1"
            )
            val upSideIndex = output().indexOf("[   | O | X ]")
            val downSideIndex = output().indexOf("[ O |   |   ]")
            assertThat(upSideIndex).isLessThan(downSideIndex)
        }, 0, 1, 0)
    }

    override fun runMain() {
        main()
    }
}
