package bridge

import org.assertj.core.api.Assertions.assertThat
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import service.OutputView
import service.main

class OutputViewTest : NsTest() {
    @Test
    fun `다리 생성 테스트1`() {
        assertSimpleTest {
            val numberGenerator: BridgeNumberGenerator = ApplicationTest.TestNumberGenerator(listOf(1, 0, 0))
            val bridgeMaker = BridgeMaker(numberGenerator)
            val bridge: List<String> = bridgeMaker.makeBridge(3)
            val bridgeGame = BridgeGame()
            bridgeGame.move("U")
            bridgeGame.move("D")
            bridgeGame.move("D")

            val outputView = OutputView()
            outputView.printMap(bridgeGame.getState(bridge))

            assertThat(output()).contains(
                    "[ O |   |   ]",
                    "[   | O | O ]"
            )
        }
    }

    @Test
    fun `다리 생성 테스트2`() {
        assertSimpleTest {
            val numberGenerator: BridgeNumberGenerator = ApplicationTest.TestNumberGenerator(listOf(1, 1, 1))
            val bridgeMaker = BridgeMaker(numberGenerator)
            val bridge: List<String> = bridgeMaker.makeBridge(3)
            val bridgeGame = BridgeGame()
            bridgeGame.move("U")
            bridgeGame.move("U")
            bridgeGame.move("D")

            val outputView = OutputView()
            outputView.printMap(bridgeGame.getState(bridge))

            assertThat(output()).contains(
                    "[ O | O |   ]",
                    "[   |   | X ]"
            )
        }
    }

    @Test
    fun `다리 생성 테스트3`() {
        assertSimpleTest {
            val numberGenerator: BridgeNumberGenerator = ApplicationTest.TestNumberGenerator(listOf(1, 0, 1, 1, 0))
            val bridgeMaker = BridgeMaker(numberGenerator)
            val bridge: List<String> = bridgeMaker.makeBridge(5)
            val bridgeGame = BridgeGame()
            bridgeGame.move("U")
            bridgeGame.move("D")
            bridgeGame.move("U")
            bridgeGame.move("U")
            bridgeGame.move("D")

            val outputView = OutputView()
            outputView.printMap(bridgeGame.getState(bridge))

            assertThat(output()).contains(
                    "[ O |   | O | O |   ]",
                    "[   | O |   |   | O ]"
            )
        }
    }

    @Test
    fun `다리 생성 예외 테스트1`() {
        assertSimpleTest {
            val numberGenerator: BridgeNumberGenerator = ApplicationTest.TestNumberGenerator(listOf(1, 0, 3))
            val bridgeMaker = BridgeMaker(numberGenerator)
            val bridge: List<String> = bridgeMaker.makeBridge(3)

            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `다리 생성 예외 테스트2`() {
        assertSimpleTest {
            val numberGenerator: BridgeNumberGenerator = ApplicationTest.TestNumberGenerator(listOf(1, 0))
            val bridgeMaker = BridgeMaker(numberGenerator)
            val bridge: List<String> = bridgeMaker.makeBridge(2)

            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}