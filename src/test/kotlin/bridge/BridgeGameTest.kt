package bridge

import bridge.view.main
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BridgeGameTest : NsTest() {

    @Test
    fun `종료 테스트`() {
        assertRandomNumberInRangeTest(
            {
                run("3", "D", "Q")
                assertThat(output()).contains(
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
            }, 1, 0, 1)
    }

    @Test
    fun `재시작 테스트`() {
        assertRandomNumberInRangeTest(
            {
                run("3", "D", "R", "U", "D", "U")
                assertThat(output()).contains(
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                    "[   ]",
                    "[ X ]",
                    "[ O ]",
                    "[   ]",
                    "[ O |   ]",
                    "[   | O ]",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "최종 게임 결과",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
                )
                val upsideIndex = output().indexOf("[ O |   | O ]")
                val downSideIndex = output().indexOf("[   | O |   ]")
                assertThat(upsideIndex).isLessThan(downSideIndex)
            }, 1, 0, 1
        )
    }

    override fun runMain() {
        main()
    }
}