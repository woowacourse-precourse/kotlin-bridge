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
    fun `예외 테스트`() {
        assertSimpleTest {
            runException("a")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `아무것도 안쓰는 경우`() {
        assertSimpleTest {
            runException(null)
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `3 이상 20 이하의 숫자가 아닌 경우`() {
        assertSimpleTest {
            runException("21")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `이동할 칸 입력이 U나 D가 아닌 경우`() {
        assertSimpleTest {
            runException("3", "t")
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
