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
    fun `기능 테스트 without retry`() {
        assertRandomNumberInRangeTest({
            run("3", "U", "D", "U")
            assertThat(output()).contains("최종 게임 결과", "[ O |   | O ]", "[   | O |   ]", "게임 성공 여부: 성공", "총 시도한 횟수: 1")
            val upSideIndex = output().indexOf("[ O |   | O ]")
            val downSideIndex = output().indexOf("[   | O |   ]")
            assertThat(upSideIndex).isLessThan(downSideIndex)
        }, 1, 0, 1)
    }

    @Test
    fun `기능 테스트 with retry`() {
        assertRandomNumberInRangeTest({
            run("5", "U", "D", "D", "R", "U", "D", "U", "U", "U")
            assertThat(output()).contains("[ O |   |   ]\n[   | O | X ]", "최종 게임 결과", "[ O |   | O | O | O ]\n[   | O |   |   |   ]", "게임 성공 여부: 성공", "총 시도한 횟수: 2")
        }, 1, 0, 1, 1, 1)
    }

    @Test
    fun `예외 테스트 - 다리의 길이에 문자가 입력되는 경우`() {
        assertSimpleTest {
            runException("a")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }
    @Test
    fun `예외 테스트 - 다리의 길이가 범위를 벗어나는 경우`() {
        assertSimpleTest {
            runException("2")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
        assertSimpleTest {
            runException("21")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `예외 테스트 - 위 아래가 U, D가 아닌 문자로 입력되는 경우`() {
        assertSimpleTest {
            runException("4", "R")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `예외 테스트 - 게임 재시도 여부가 R, Q가 아닌 다른 문자로 입력되는 경우`() {
        assertRandomNumberInRangeTest({
            runException("3", "D", "Y")
            assertThat(output()).contains(ERROR_MESSAGE)
        }, 1, 0, 1)
    }

    @Test
    fun `move 함수 테스트` () {
        val bridge = make_bridge(listOf(0,0,0))
        val game = BridgeGame(bridge)
        assert(!game.move(0, "U"))
        assert(game.move(0, "D"))
    }

    @Test
    fun `gameToString 함수 테스트` () {
        val bridgeNumbers = listOf(0,1,0,1,0,1,1,1,0,0)
        val bridge = make_bridge(bridgeNumbers)
        val game = BridgeGame(bridge)
        for(i in bridgeNumbers.indices) {
            if(bridgeNumbers[i] == 1) game.move(i, "U")
            else game.move(i, "D")
        }
        assert(game.gameToString() == "[   | O |   | O |   | O | O | O |   |   ]\n[ O |   | O |   | O |   |   |   | O | O ]")
    }


    private fun make_bridge(bridge: List<Int>): List<String> {
        val numberGenerator: BridgeNumberGenerator = ApplicationTest.TestNumberGenerator(bridge)
        val bridgeMaker = BridgeMaker(numberGenerator)
        return bridgeMaker.makeBridge(bridge.size)
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
