package bridge

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ApplicationTest : NsTest() {
    @Test
    fun `다리 생성 테스트`() {
        val numberGenerator: BridgeNumberGenerator = TestNumberGenerator(listOf(1, 0, 0))
        val bridgeMaker = BridgeMaker(numberGenerator)
        val bridge: List<String> = bridgeMaker.makeBridge(3)
        assertThat(bridge).containsExactly("U", "D", "D")
    }

    @Test
    fun `기능 테스트`() {
        assertRandomNumberInRangeTest({
            run("3", "U", "D", "U")
            assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   | O ]",
                "[   | O |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 1"
            )
            val upSideIndex = output().indexOf("[ O |   | O ]")
            val downSideIndex = output().indexOf("[   | O |   ]")
            assertThat(upSideIndex).isLessThan(downSideIndex)
        }, 1, 0, 1)
    }

    @Test
    fun `기능 테스트2`() {
        assertRandomNumberInRangeTest({
            run("3", "U", "D", "U", "Q")
            assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   | X ]",
                "[   | O |   ]",
                "게임 성공 여부: 실패",
                "총 시도한 횟수: 1"
            )
            val upSideIndex = output().indexOf("[ O |   | X ]")
            val downSideIndex = output().indexOf("[   | O |   ]")
            assertThat(upSideIndex).isLessThan(downSideIndex)
        }, 1, 0, 0)
    }

    @Test
    fun `기능 테스트3`() {
        assertRandomNumberInRangeTest({
            run("3", "U", "D", "U", "R", "U", "D", "D")
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
    fun `기능 테스트4`() {
        assertRandomNumberInRangeTest({
            run("4", "U", "R", "D", "U", "R", "D", "D", "D", "U")
            assertThat(output()).contains(
                "최종 게임 결과",
                "[   |   |   | O ]",
                "[ O | O | O |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 3"
            )
            val upSideIndex = output().indexOf("[   |   |   | O ]")
            val downSideIndex = output().indexOf("[ O | O | O |   ]")
            assertThat(upSideIndex).isLessThan(downSideIndex)
        }, 0, 0, 0, 1)
    }

    @Test
    fun `다리 사이즈 입력 숫자 여부 예외 테스트`() {
        assertSimpleTest {
            runException("a")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `다리 사이즈 입력 범위 예외 테스트`() {
        assertSimpleTest {
            runException("21")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `moving 입력 예외 테스트`() {
        assertSimpleTest {
            runException("3", "Y")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `gameCommand 입력 예외 테스트`() {
        assertSimpleTest {
            runException("3", "U", "N")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
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
