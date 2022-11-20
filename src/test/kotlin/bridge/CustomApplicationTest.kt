package bridge

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CustomApplicationTest : NsTest() {
    @Test
    fun `실패 후 재 시작시 잘 작동한다`() {
        assertRandomNumberInRangeTest({
            run("3", "U", "U", "R", "U", "D", "D")
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

    @Test
    fun `중간에 포기 정상 작동 확인`() {
        assertRandomNumberInRangeTest({
            run("3", "U", "U", "Q")
            assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   ]",
                "[   | X ]",
                "게임 성공 여부: 실패",
                "총 시도한 횟수: 1"
            )
            val upSideIndex = output().indexOf("[ O |   ]")
            val downSideIndex = output().indexOf("[   | X ]")
            assertThat(upSideIndex).isLessThan(downSideIndex)
        }, 1, 0, 0)
    }

    override fun runMain() {
        main()
    }

    class TestNumberGenerator(numbers: List<Int>) : BridgeNumberGenerator {
        private val numbers: MutableList<Int> = numbers.toMutableList()

        override fun generate(): Int {
            return numbers.removeAt(0)
        }
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}
