package bridge.view

import bridge.domain.BridgeMaker
import bridge.domain.BridgeNumberGenerator
import bridge.main
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest

class OutputViewTest : NsTest() {

    lateinit var bridgeMaker: BridgeMaker
    lateinit var outputView: OutputView

    @BeforeEach
    fun setUp() {
        bridgeMaker = BridgeMaker(TestNumberGenerator(listOf(1, 0, 0)))
        outputView = OutputView()
    }

    @Test
    fun `다리가 출력용으로 제대로 변환되어서 출력되는지 확인`() {
        val answerBridge = bridgeMaker.makeBridge(3)
        outputView.init(answerBridge, bridgeMaker)
        outputView.printMap(2, isCorrectDirection = true)
        assertSimpleTest {
            assertThat(output()).isEqualTo(
                """
                [ O |   |   ]
                [   | O | O ]
                """.trimIndent()
            )
        }
    }

    @Test
    fun `원소가 하나여도 잘 나오는지 확인`() {
        val answerBridge = bridgeMaker.makeBridge(1)
        outputView.init(answerBridge, bridgeMaker)
        outputView.printMap(0, isCorrectDirection = true)
        assertSimpleTest {
            assertThat(output()).isEqualTo(
                """
                [ O ]
                [   ]
                """.trimIndent()
            )
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