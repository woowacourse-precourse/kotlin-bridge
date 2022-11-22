package bridge

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class FunctionTest : NsTest() {
    @Test
    fun `기능 테스트`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest({
            run("3", "U", "U", "R", "U", "D", "D")
            Assertions.assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   |   ]",
                "[   | O | O ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 2"
            )
            val upSideIndex = output().indexOf("[ O |   |   ]")
            val downSideIndex = output().indexOf("[   | O | O ]")
            Assertions.assertThat(upSideIndex).isLessThan(downSideIndex)
        }, 1, 0, 0)
    }

    override fun runMain() {
        main()
    }

}