package bridge

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

open class InputViewTest: NsTest() {
    class readBridgeSizeTest: InputViewTest() {
        @Test
        @DisplayName("입력값이 범위 내 숫자일 때 정상적으로 입력받는다.")
        fun `readBridgeSize normal`() {
            assertSimpleTest {
                run("3")
            }
        }
        @Test
        @DisplayName("입력값이 숫자가 아닐 때 예외를 발생시킨다.")
        fun `readBridgeSize exception !int`() {
            assertSimpleTest {
                runException("a")
                assertThat(output()).contains(InputViewTest.ERROR_MESSAGE)
            }
        }
        @Test
        @DisplayName("입력값이 2일 때 예외를 발생시킨다.")
        fun `readBridgeSize exception 2`() {
            assertSimpleTest {
                runException("2")
                assertThat(output()).contains(InputViewTest.ERROR_MESSAGE)
            }
        }
        @Test
        @DisplayName("입력값이 21일 때 예외를 발생시킨다.")
        fun `readBridgeSize exception 21`() {
            assertSimpleTest {
                runException("21")
                assertThat(output()).contains(InputViewTest.ERROR_MESSAGE)
            }
        }
        override fun runMain() {
            InputView().readBridgeSize()
        }
    }
    class readMovingTest: InputViewTest() {
        @Test
        @DisplayName("입력값이 U일 때 정상적으로 입력받는다.")
        fun `readMovingDirection normal U`() {
            assertSimpleTest {
                run("U")
                assertThat(output()).contains("U")
            }
        }
        @Test
        @DisplayName("입력값이 D일 때 정상적으로 입력받는다.")
        fun `readMovingDirection normal D`() {
            assertSimpleTest {
                run("D")
                assertThat(output()).contains("D")
            }
        }
        @Test
        @DisplayName("입력값이 U, D가 아닐 때 예외를 발생시킨다.")
        fun `readMovingDirection exception !UD`() {
            assertSimpleTest {
                runException("a")
                assertThat(output()).contains(InputViewTest.ERROR_MESSAGE)
            }
        }
        @Test
        @DisplayName("입력값이 UU일 때 예외를 발생시킨다.")
        fun `readMovingDirection exception UU`() {
            assertSimpleTest {
                runException("UU")
                assertThat(output()).contains(InputViewTest.ERROR_MESSAGE)
            }
        }
        override fun runMain() {
            InputView().readMoving()
        }
    }

   class readGameCommandTest: InputViewTest() {
        @Test
        @DisplayName("입력값이 R일 때 정상적으로 입력받는다.")
        fun `readGameCommand normal R`() {
            assertSimpleTest {
                run("R")
                assertThat(output()).contains("R")
            }
        }
        @Test
        @DisplayName("입력값이 Q일 때 정상적으로 입력받는다.")
        fun `readGameCommand normal Q`() {
            assertSimpleTest {
                run("Q")
                assertThat(output()).contains("Q")
            }
        }
        @Test
        @DisplayName("입력값이 R, Q가 아닐 때 예외를 발생시킨다.")
        fun `readGameCommand exception !RQ`() {
            assertSimpleTest {
                runException("a")
                assertThat(output()).contains(InputViewTest.ERROR_MESSAGE)
            }
        }
        @Test
        @DisplayName("입력값이 RR일 때 예외를 발생시킨다.")
        fun `readGameCommand exception RR`() {
            assertSimpleTest {
                runException("RR")
                assertThat(output()).contains(InputViewTest.ERROR_MESSAGE)
            }
        }
        override fun runMain() {
            InputView().readGameCommand()
        }
    }

    override fun runMain() {
        readBridgeSizeTest()
        readMovingTest()
        readGameCommandTest()
    }
    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}

open class OutputViewTest: NsTest() {
    class printGameStartTest: OutputViewTest() {
        @Test
        @DisplayName("게임 시작 메시지를 출력한다.")
        fun `print GameStart Message`() {
            assertSimpleTest {
                OutputView().printGameStart()
                assertThat(output()).contains(GAME_START_MESSAGE)
            }
        }
    }

    class printMapTest: OutputViewTest() {
        @ParameterizedTest
        @ValueSource(strings = ["UDU"])
        @DisplayName("맵을 출력한다. 0")
        fun `print Map Test 0 `(Moving: String) {
            assertSimpleTest {
                val numberGenerator: BridgeNumberGenerator =
                    BrigeGameTest.TestNumberGenerator(listOf(1, 0, 1))
                val bridgeGame = BridgeGame(BridgeMaker(numberGenerator),3)
                Moving.forEachIndexed { index, it -> bridgeGame.move(it.toString(), index)}
                OutputView().printMap(bridgeGame.getCurBridge())
                assertThat(output()).contains(
                    "[ O |   | O ]",
                    "[   | O |   ]",
                )
            }
        }
        @ParameterizedTest
        @ValueSource(strings = ["UDU"])
        @DisplayName("맵을 출력한다. 1")
        fun `print Map Test 1 `(Moving: String) {
            assertSimpleTest {
                val numberGenerator: BridgeNumberGenerator =
                    BrigeGameTest.TestNumberGenerator(listOf(1, 0, 0))
                val bridgeGame = BridgeGame(BridgeMaker(numberGenerator),3)
                Moving.forEachIndexed { index, it -> bridgeGame.move(it.toString(), index)}
                OutputView().printMap(bridgeGame.getCurBridge())
                assertThat(output()).contains(
                    "[ O |   | X ]",
                    "[   | O |   ]",
                )
            }
        }
        @ParameterizedTest
        @ValueSource(strings = ["U"])
        @DisplayName("맵을 출력한다. 2")
        fun `print Map Test 2 `(Moving: String) {
            assertSimpleTest {
                val numberGenerator: BridgeNumberGenerator =
                    BrigeGameTest.TestNumberGenerator(listOf(1, 0, 0))
                val bridgeGame = BridgeGame(BridgeMaker(numberGenerator),3)
                Moving.forEachIndexed { index, it -> bridgeGame.move(it.toString(), index)}
                OutputView().printMap(bridgeGame.getCurBridge())
                assertThat(output()).contains(
                    "[ O ]",
                    "[   ]",
                )
            }
        }
        @ParameterizedTest
        @ValueSource(strings = ["D"])
        @DisplayName("맵을 출력한다. 3")
        fun `print Map Test 3 `(Moving: String) {
            assertSimpleTest {
                val numberGenerator: BridgeNumberGenerator =
                    BrigeGameTest.TestNumberGenerator(listOf(1, 0, 0))
                val bridgeGame = BridgeGame(BridgeMaker(numberGenerator),3)
                Moving.forEachIndexed { index, it -> bridgeGame.move(it.toString(), index)}
                OutputView().printMap(bridgeGame.getCurBridge())
                assertThat(output()).contains(
                    "[   ]",
                    "[ X ]",
                )
            }
        }
        @ParameterizedTest
        @ValueSource(strings = ["UD"])
        @DisplayName("맵을 출력한다. 4")
        fun `print Map Test 4 `(Moving: String) {
            assertSimpleTest {
                val numberGenerator: BridgeNumberGenerator =
                    BrigeGameTest.TestNumberGenerator(listOf(1, 0, 0))
                val bridgeGame = BridgeGame(BridgeMaker(numberGenerator),3)
                Moving.forEachIndexed { index, it -> bridgeGame.move(it.toString(), index)}
                OutputView().printMap(bridgeGame.getCurBridge())
                assertThat(output()).contains(
                    "[ O |   ]",
                    "[   | O ]"
                )
            }
        }

        @ParameterizedTest
        @ValueSource(strings = ["UU"])
        @DisplayName("맵을 출력한다. 5")
        fun `print Map Test 5 `(Moving: String) {
            assertSimpleTest {
                val numberGenerator: BridgeNumberGenerator =
                    BrigeGameTest.TestNumberGenerator(listOf(1, 0, 0))
                val bridgeGame = BridgeGame(BridgeMaker(numberGenerator),3)
                Moving.forEachIndexed { index, it -> bridgeGame.move(it.toString(), index)}
                OutputView().printMap(bridgeGame.getCurBridge())
                assertThat(output()).contains(
                    "[ O | X ]",
                    "[   |   ]"
                )
            }
        }
    }

    class printResultTest: OutputViewTest() {
        @ParameterizedTest
        @ValueSource(strings = ["UDU"])
        @DisplayName("최종 결과을 출력한다. 0")
        fun `print Result Test 0 `(Moving: String) {
            assertSimpleTest {
                val numberGenerator: BridgeNumberGenerator =
                    BrigeGameTest.TestNumberGenerator(listOf(1, 0, 1))
                val bridgeGame = BridgeGame(BridgeMaker(numberGenerator),3)
                Moving.forEachIndexed { index, it -> bridgeGame.move(it.toString(), index)}
                OutputView().printResult(bridgeGame.getCurBridge(), bridgeGame)
                assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1"
                )
            }
        }
        @ParameterizedTest
        @ValueSource(strings = ["UU"])
        @DisplayName("최종 결과을 출력한다. 1")
        fun `print Result Test 1 `(Moving: String) {
            assertSimpleTest {
                val numberGenerator: BridgeNumberGenerator =
                    BrigeGameTest.TestNumberGenerator(listOf(1, 0, 1))
                val bridgeGame = BridgeGame(BridgeMaker(numberGenerator),3)
                Moving.forEachIndexed { index, it -> bridgeGame.move(it.toString(), index)}
                OutputView().printResult(bridgeGame.getCurBridge(), bridgeGame)
                assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O | X ]",
                    "[   |   ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
                )
            }
        }

        @Test
        @DisplayName("최종 결과을 출력한다. 2")
        fun `print Result Test 2 `() {
            assertSimpleTest {
                var Moving = "UU"
                val numberGenerator: BridgeNumberGenerator =
                    BrigeGameTest.TestNumberGenerator(listOf(1, 0, 1))
                val bridgeGame = BridgeGame(BridgeMaker(numberGenerator),3)
                Moving.forEachIndexed { index, it -> bridgeGame.move(it.toString(), index)}
                bridgeGame.retry("R")
                Moving = "UDU"
                Moving.forEachIndexed { index, it -> bridgeGame.move(it.toString(), index)}
                OutputView().printResult(bridgeGame.getCurBridge(), bridgeGame)
                assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
                )
            }
        }
    }
    override fun runMain() {
        printGameStartTest()
        printMapTest()
        printResultTest()
    }

    class TestNumberGenerator(numbers: List<Int>) : BridgeNumberGenerator {
        private val numbers: MutableList<Int> = numbers.toMutableList()

        override fun generate(): Int {
            return numbers.removeAt(0)
        }
    }
    companion object {
        private const val GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다."
        private const val GAME_RESULT_MESSAGE = "최종 게임 결과"
        private const val GAME_SUCCESS_MESSAGE = "게임 성공 여부 : "
        private const val GAME_TRY_MESSAGE = "총 시도한 횟수 : "
    }
}
