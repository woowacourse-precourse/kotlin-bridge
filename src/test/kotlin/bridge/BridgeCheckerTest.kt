package bridge

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class BridgeCheckerTest : NsTest() {
    @Test
    fun `다리 생성 후 정답 체크 테스트 1`() {
        val numberGenerator: BridgeNumberGenerator = TestNumberGenerator(listOf(1, 0, 0))
        val bridgeMaker = BridgeMaker(numberGenerator)
        val bridgeChecker = BridgeChecker(3, bridgeMaker)
        val sb = StringBuilder()

        bridgeChecker.updateWithChecking("U")
        sb.append(bridgeChecker.toStringOpenPart()).append("\n")

        bridgeChecker.updateWithChecking("D")
        sb.append(bridgeChecker.toStringOpenPart()).append("\n")

        bridgeChecker.updateWithChecking("D")
        sb.append(bridgeChecker.toStringOpenPart()).append("\n")

        println(bridgeChecker.toStringOpenPart())

        Assertions.assertThat(sb.toString()).contains(
            """[ O |   |   ]
                |[   | O | O ]""".trimMargin()
        )
    }

    @Test
    fun `다리 생성 후 정답 체크 테스트 2`() {
        val numberGenerator: BridgeNumberGenerator = TestNumberGenerator(listOf(1, 0, 0))
        val bridgeMaker = BridgeMaker(numberGenerator)
        val bridgeChecker = BridgeChecker(3, bridgeMaker)
        val sb = StringBuilder()

        bridgeChecker.updateWithChecking("U")
        sb.append(bridgeChecker.toStringOpenPart()).append("\n")

        bridgeChecker.updateWithChecking("U")
        sb.append(bridgeChecker.toStringOpenPart()).append("\n")

        println(bridgeChecker.toStringOpenPart())

        Assertions.assertThat(sb.toString()).contains(
            """[ O | X ]
                |[   |   ]""".trimMargin()
        )
    }

    @Test
    fun `다리 생성 후 정답 체크 테스트 3`() {
        val numberGenerator: BridgeNumberGenerator = TestNumberGenerator(listOf(1, 0, 0))
        val bridgeMaker = BridgeMaker(numberGenerator)
        val bridgeChecker = BridgeChecker(3, bridgeMaker)
        val sb = StringBuilder()

        bridgeChecker.updateWithChecking("U")
        sb.append(bridgeChecker.toStringOpenPart()).append("\n")

        println(bridgeChecker.toStringOpenPart())

        Assertions.assertThat(sb.toString()).contains(
            """[ O ]
                |[   ]""".trimMargin()
        )
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