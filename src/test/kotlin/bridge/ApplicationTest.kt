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
    fun `기능 테스트 2`() {
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
    fun `기능 테스트 3`() {
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
        }, 1, 0, 0)
    }

    @Test
    fun `기능 테스트 4`() {
        assertRandomNumberInRangeTest({
            run("3", "U", "D", "D", "Q")
            assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   |   ]",
                "[   | O | X ]",
                "게임 성공 여부: 실패",
                "총 시도한 횟수: 1"
            )
            val upSideIndex = output().indexOf("[ O |   |   ]")
            val downSideIndex = output().indexOf("[   | O | X ]")
            assertThat(upSideIndex).isLessThan(downSideIndex)
        }, 1, 0, 1)
    }

    @Test
    fun `기능 테스트 5`() {
        assertRandomNumberInRangeTest({
            run("3", "U", "D", "D", "R", "U", "D", "D", "R", "U", "D", "U")
            assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   | O ]",
                "[   | O |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 3"
            )
            val upSideIndex = output().indexOf("[ O |   | O ]")
            val downSideIndex = output().indexOf("[   | O |   ]")
            assertThat(upSideIndex).isLessThan(downSideIndex)
        }, 1, 0, 1)
    }

    @Test
    fun `기능 테스트 6`() {
        assertRandomNumberInRangeTest({
            run("3", "U", "D", "D", "R", "D", "Q")
            assertThat(output()).contains(
                "최종 게임 결과",
                "[   ]",
                "[ X ]",
                "게임 성공 여부: 실패",
                "총 시도한 횟수: 2"
            )
            val upSideIndex = output().indexOf("[   ]")
            val downSideIndex = output().indexOf("[ X ]")
            assertThat(upSideIndex).isLessThan(downSideIndex)
        }, 1, 0, 1)
    }

    @Test
    fun `허용 범위 미만의 다리 길이 입력이 들어오면 에러 출력 후 다시 입력받고 진행한다`() {
        assertRandomNumberInRangeTest({
            run("2", "4", "U", "D", "D", "U")
            assertThat(output()).contains(
                ERROR_MESSAGE,
                "최종 게임 결과",
                "[ O |   |   | O ]",
                "[   | O | O |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 1"
            )
            val upSideIndex = output().indexOf("[ O |   |   | O ]")
            val downSideIndex = output().indexOf("[   | O | O |   ]")
            assertThat(upSideIndex).isLessThan(downSideIndex)
        }, 1, 0, 0, 1)
    }

    @Test
    fun `허용 범위 초과의 다리 길이 입력이 들어오면 에러 출력 후 다시 입력받고 진행한다`() {
        assertRandomNumberInRangeTest({
            run("21", "4", "U", "D", "D", "U")
            assertThat(output()).contains(
                ERROR_MESSAGE,
                "최종 게임 결과",
                "[ O |   |   | O ]",
                "[   | O | O |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 1"
            )
            val upSideIndex = output().indexOf("[ O |   |   | O ]")
            val downSideIndex = output().indexOf("[   | O | O |   ]")
            assertThat(upSideIndex).isLessThan(downSideIndex)
        }, 1, 0, 0, 1)
    }

    @Test
    fun `허용하지 않는 이동 입력이면 에러 출력 후 다시 입력받고 진행한다`() {
        assertRandomNumberInRangeTest({
            run("4", "U", "D", "D", "1", "U")
            assertThat(output()).contains(
                ERROR_MESSAGE,
                "최종 게임 결과",
                "[ O |   |   | O ]",
                "[   | O | O |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 1"
            )
            val upSideIndex = output().indexOf("[ O |   |   | O ]")
            val downSideIndex = output().indexOf("[   | O | O |   ]")
            assertThat(upSideIndex).isLessThan(downSideIndex)
        }, 1, 0, 0, 1)
    }

    @Test
    fun `허용하지 않는 재시작 입력이면 에러 출력 후 다시 입력받고 진행한다`() {
        assertRandomNumberInRangeTest({
            run("4", "U", "D", "U", "가", "R", "U", "D", "D", "U")
            assertThat(output()).contains(
                ERROR_MESSAGE,
                "최종 게임 결과",
                "[ O |   |   | O ]",
                "[   | O | O |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 2"
            )
            val upSideIndex = output().indexOf("[ O |   |   | O ]")
            val downSideIndex = output().indexOf("[   | O | O |   ]")
            assertThat(upSideIndex).isLessThan(downSideIndex)
        }, 1, 0, 0, 1)
    }

    @Test
    fun `허용하지 않는 종료 입력이면 에러 출력 후 다시 입력받고 종료한다`() {
        assertRandomNumberInRangeTest({
            run("4", "U", "D", "U", "*", "Q")
            assertThat(output()).contains(
                ERROR_MESSAGE,
                "최종 게임 결과",
                "[ O |   | X ]",
                "[   | O |   ]",
                "게임 성공 여부: 실패",
                "총 시도한 횟수: 1"
            )
            val upSideIndex = output().indexOf("[ O |   | X ]")
            val downSideIndex = output().indexOf("[   | O |   ]")
            assertThat(upSideIndex).isLessThan(downSideIndex)
        }, 1, 0, 0, 1)
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            runException("a")
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
