package bridge

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.DisplayName

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