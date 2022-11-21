package bridge

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ApplicationTestCustom : NsTest() {
    @Test
    fun `기능 테스트1`() {
        assertRandomNumberInRangeTest({
            run("3", "U", "U", "R", "U", "D", "U")
            assertThat(output()).contains(
                "최종 게임 결과",
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
    fun `기능 테스트2`() {
        assertRandomNumberInRangeTest({
            run("3", "U", "U", "Q")
            assertThat(output()).contains(
                "최종 게임 결과",
                "[ O | X ]",
                "[   |   ]",
                "게임 성공 여부: 실패",
                "총 시도한 횟수: 1"
            )
            val upSideIndex = output().indexOf("[ O | X ]")
            val downSideIndex = output().indexOf("[   |   ]")
            assertThat(upSideIndex).isLessThan(downSideIndex)
        }, 1, 0, 1)
    }

    override fun runMain() {
        main()
    }
}
