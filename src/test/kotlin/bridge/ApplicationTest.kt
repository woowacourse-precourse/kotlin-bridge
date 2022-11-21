package bridge

import bridge.domain.BridgeMaker
import bridge.util.BridgeNumberGenerator
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
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
    fun `다리 생성 테스트2`() {
        val numberGenerator: BridgeNumberGenerator = TestNumberGenerator(listOf(1, 1, 1))
        val bridgeMaker = BridgeMaker(numberGenerator)
        val bridge: List<String> = bridgeMaker.makeBridge(3)
        assertThat(bridge).containsExactly("U", "U", "U")
    }

    @Test
    fun `기능 테스트`() {
        assertRandomNumberInRangeTest(
            {
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
            },
            1, 0, 1
        )
    }

    @Test
    @DisplayName("두 번째에 성공 했을 때")
    fun `기능 테스트2`() {
        assertRandomNumberInRangeTest(
            {
                run("3", "U", "D", "D", "R", "U", "D", "U")
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
            },
            1, 0, 1
        )
    }

    @Test
    @DisplayName("세 번째에 성공 했을 때")
    fun `기능 테스트3`() {
        assertRandomNumberInRangeTest(
            {
                run("3", "U", "D", "D", "R", "U", "U", "R", "U", "D", "U")
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
            },
            1, 0, 1
        )
    }

    @Test
    @DisplayName("세 번째에 실패 했을 때")
    fun `기능 테스트4`() {
        assertRandomNumberInRangeTest(
            {
                run("3", "U", "D", "D", "R", "U", "U", "R", "U", "D", "D", "Q")
                assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   |   ]",
                    "[   | O | X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 3"
                )
                val upSideIndex = output().indexOf("[ O |   |   ]")
                val downSideIndex = output().indexOf("[   | O | X ]")
                assertThat(upSideIndex).isLessThan(downSideIndex)
            },
            1, 0, 1
        )
    }

    @Test
    @DisplayName("첫 번째에 실패 했을 때")
    fun `기능 테스트5`() {
        assertRandomNumberInRangeTest(
            {
                run("3", "D", "Q")
                assertThat(output()).contains(
                    "최종 게임 결과",
                    "[   ]",
                    "[ X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
                )
                val upSideIndex = output().indexOf("[   ]")
                val downSideIndex = output().indexOf("[ X ]")
                assertThat(upSideIndex).isLessThan(downSideIndex)
            },
            1, 0, 1
        )
    }

    @Test
    @DisplayName("두 번째에 실패 했을 때")
    fun `기능 테스트6`() {
        assertRandomNumberInRangeTest(
            {
                run("3", "D", "R", "U", "U", "Q")
                assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O | X ]",
                    "[   |   ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 2"
                )
                val upSideIndex = output().indexOf("[ O | X ]")
                val downSideIndex = output().indexOf("[   |   ]")
                assertThat(upSideIndex).isLessThan(downSideIndex)
            },
            1, 0, 1
        )
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            runException("a")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    @DisplayName("음수일 경우")
    fun `예외 테스트2`() {
        assertSimpleTest {
            runException("-1")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    @DisplayName("부동소수점일 경우")
    fun `예외 테스트3`() {
        assertSimpleTest {
            runException("1.3")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    @DisplayName("작은 경계값일 경우")
    fun `예외 테스트4`() {
        assertSimpleTest {
            runException("2")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    @DisplayName("큰 경계값일 경우")
    fun `예외 테스트5`() {
        assertSimpleTest {
            runException("21")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    @DisplayName("0을 입력했을 경우")
    fun `예외 테스트6`() {
        assertSimpleTest {
            runException("0")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    @DisplayName("특수문자일 경우")
    fun `예외 테스트7`() {
        assertSimpleTest {
            runException("??")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    @DisplayName("굉장히 큰 수일 경우")
    fun `예외 테스트8`() {
        assertSimpleTest {
            runException("10000000000000000000000000000")
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
