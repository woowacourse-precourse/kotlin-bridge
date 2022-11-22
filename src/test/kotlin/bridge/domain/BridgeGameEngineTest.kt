package bridge.domain

import bridge._util.countOf
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class BridgeGameEngineTest : NsTest() {

    private lateinit var gameEngine: BridgeGameEngine

    @BeforeEach
    fun beforeEach() {
        gameEngine = BridgeGameEngine()
    }

    @Test
    fun `기능테스트_성공_시도횟수1`() {
        testSimple(
            bridgeNumbers = listOf(1, 0, 0, 1),
            inputs = listOf("4", "U", "D", "D", "U"),
            outputs = listOf(
                "최종 게임 결과",
                "[ O |   |   | O ]",
                "[   | O | O |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 1",
            ),
        )
    }

    @Test
    fun `기능테스트_성공_시도횟수2`() {
        testSimple(
            bridgeNumbers = listOf(1, 0, 0, 1),
            inputs = listOf("4", "U", "D", "U", "R", "U", "D", "D", "U"),
            outputs = listOf(
                "최종 게임 결과",
                "[ O |   |   | O ]",
                "[   | O | O |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 2",
            ),
        )
    }

    @Test
    fun `기능테스트_실패_시도횟수2`() {
        testSimple(
            bridgeNumbers = listOf(1, 0, 0, 1),
            inputs = listOf("4", "U", "D", "U", "R", "U", "D", "D", "D", "Q"),
            outputs = listOf(
                "최종 게임 결과",
                "[ O |   |   |   ]",
                "[   | O | O | X ]",
                "게임 성공 여부: 실패",
                "총 시도한 횟수: 2",
            ),
        )
    }

    @Test
    fun `기능테스트_에러2_실패_시도횟수2`() {
        testSimple(
            bridgeNumbers = listOf(1, 0, 0, 1),
            inputs = listOf("4", "U", "D", "U", "r", "R", "U", "D", "D", "D", "q", "Q"),
            outputs = listOf(
                "최종 게임 결과",
                "[ O |   |   |   ]",
                "[   | O | O | X ]",
                "게임 성공 여부: 실패",
                "총 시도한 횟수: 2",
            ),
            errorCount = 2,
        )
    }

    private fun testSimple(
        bridgeNumbers: List<Int>,
        inputs: List<String>,
        outputs: List<String>,
        upSide: Int = 1,
        downSide: Int = 2,
        errorCount: Int = 0,
    ) {
        assertRandomNumberInRangeTest({
            run(*inputs.toTypedArray())

            assertThat(output()).contains(outputs)

            val upSideIndex = output().indexOf(outputs[upSide])
            val downSideIndex = output().indexOf(outputs[downSide])

            assertThat(upSideIndex).isLessThan(downSideIndex)

            if (errorCount > 0) {
                val count = output().countOf(ERROR_MESSAGE)

                assertThat(count).isEqualTo(errorCount)
            }
        }, bridgeNumbers[0], *bridgeNumbers.drop(1).toTypedArray())
    }

    override fun runMain() {
        gameEngine.run()
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}