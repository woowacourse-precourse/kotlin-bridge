package bridge

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class AlsswlTest : NsTest(){

    @Test
    fun `실패하고 재시도 하여 성공했을 경우`() {
        assertRandomNumberInRangeTest({
            run("3", "U", "D", "U","R","U","D","D")
            assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   |   ]",
                "[   | O | O ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 2"
            )
            val upSideIndex = output().indexOf("[ O |   | O ]")
            val downSideIndex = output().indexOf("[   | O |   ]")
            assertThat(upSideIndex).isLessThan(downSideIndex)
        }, 1, 0, 0)
    }

    @Test
    fun `실패하고 재시도 하지 않을 경우`() {
        assertRandomNumberInRangeTest({
            run("3", "U", "D", "U","Q")
            assertThat(output()).contains(
                "최종 게임 결과",
                "게임 성공 여부: 실패",
                "총 시도한 횟수: 1"
            )
            val upSideIndex = output().indexOf("[ O |   | O ]")
            val downSideIndex = output().indexOf("[   | O |   ]")
            assertThat(upSideIndex).isLessThan(downSideIndex)
        }, 1, 0, 0)
    }

    @Test
    fun `게임 중 재시작 여부를 잘못 입력했을 때 맞을 때까지 반복해서 입력받는다`() {
        assertRandomNumberInRangeTest({
            run("3", "U", "D", "U","5","R","U","D","D")
            assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   |   ]",
                "[   | O | O ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 2"
            )
            val upSideIndex = output().indexOf("[ O |   | O ]")
            val downSideIndex = output().indexOf("[   | O |   ]")
            assertThat(upSideIndex).isLessThan(downSideIndex)
        }, 1, 0, 0)
    }
    @Test
    fun `게임 중 다리길이를 잘못 입력했을 때 맞을 때까지 반복하여 입력받는다`() {
        assertRandomNumberInRangeTest({
            run("A","1","3", "U", "D", "U","R","U","D","D")
            assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   |   ]",
                "[   | O | O ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 2"
            )
            val upSideIndex = output().indexOf("[ O |   | O ]")
            val downSideIndex = output().indexOf("[   | O |   ]")
            assertThat(upSideIndex).isLessThan(downSideIndex)
        }, 1, 0, 0)
    }

    @Test
    fun `게임 중 다리 선택에서 잘못 입력했을 때 맞을 때까지 반복하여 입력받는다`() {
        assertRandomNumberInRangeTest({
            run("3", "U", "ㅇ","3","D","U","R","U","D","D")
            assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   |   ]",
                "[   | O | O ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 2"
            )
            val upSideIndex = output().indexOf("[ O |   | O ]")
            val downSideIndex = output().indexOf("[   | O |   ]")
            assertThat(upSideIndex).isLessThan(downSideIndex)
        }, 1, 0, 0)
    }

    @Test
    fun `다리 길이로 3이상 20이하인 수가 입력되면 에러를 발생시킨다`() {
        var checkTrue = CheckTrue()
        assertThrows<IllegalArgumentException> {
            checkTrue.checkBridgeLength("1")
        }
    }

    @Test
    fun `다리 길이로 수가 아닌 것을 입력받으면 에러를 발생시킨다`() {
        var checkTrue = CheckTrue()
        assertThrows<IllegalArgumentException> {
            checkTrue.checkBridgeLength("a")
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



}