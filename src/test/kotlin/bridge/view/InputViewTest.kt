package bridge.view

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.io.ByteArrayInputStream
import java.lang.IllegalArgumentException

internal class InputViewTest {
    private val inputView = InputView()

    @Nested
    inner class `readBridgeSize 메소드는` : NsTest() {
        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        @Nested
        inner class `3 이상 20 이하의 숫자가 아닌 값을 입력받으면` {
            private fun readValues() = listOf(
                Arguments.of("-1"),
                Arguments.of("21"),
                Arguments.of("2"),
                Arguments.of("a"),
            )

            @ParameterizedTest
            @MethodSource("readValues")
            fun `예외 메세지와 함께 예외를 던진다`(readValue: String) {
                assertThatThrownBy { runException(readValue) }
                    .isInstanceOf(IllegalArgumentException::class.java)
                    .hasMessageContaining(ERROR_MESSAGE)
            }
        }

        @Nested
        inner class `3 이상 20 이하의 숫자를 입력받으면` {
            private val readValue = "3"

            @Test
            fun `입력받은 값을 반환한다`() {
                System.setIn(ByteArrayInputStream(readValue.toByteArray()))

                val bridgeSize = inputView.readBridgeSize()

                assertThat(bridgeSize).isEqualTo(3)
            }
        }

        override fun runMain() {
            inputView.readBridgeSize()
        }
    }

    @Nested
    inner class `askBridgeSizeToUser 메소드는` : NsTest() {
        @Nested
        inner class `실행하면` {
            private val readValues = listOf("-1", "2", "21", "3")

            @Test
            fun `올바른 값을 입력받을 때까지 예외 메세지를 출력하며 반복한다`() {
                System.setIn(ByteArrayInputStream(readValues.joinToString("\n").toByteArray()))

                val bridgeSize = inputView.askBridgeSizeToUser()

                assertThat(output()).contains(ERROR_MESSAGE)
                assertThat(bridgeSize).isEqualTo(3)
            }
        }

        override fun runMain() {
            inputView.askBridgeSizeToUser()
        }
    }

    @Nested
    inner class `readMoving 메소드는` : NsTest() {

        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        @Nested
        inner class `U와 D 이외의 값을 입력받으면` {
            private fun readValues() = listOf("A", "UD")

            @ParameterizedTest
            @MethodSource("readValues")
            fun `예외 메세지와 함께 예외를 던진다`(readValue: String) {
                assertThatThrownBy { runException(readValue) }
                    .isInstanceOf(IllegalArgumentException::class.java)
                    .hasMessageContaining(ERROR_MESSAGE)
            }
        }

        @Nested
        inner class `U와 D 중 하나의 값을 입력받으면`() {
            private val readValue = "U"

            @Test
            fun `입력받은 값을 반환한다`() {
                System.setIn(ByteArrayInputStream(readValue.toByteArray()))

                val moving = inputView.readMoving()

                assertThat(moving).isEqualTo("U")
            }
        }

        override fun runMain() {
            inputView.readMoving()
        }
    }

    @Nested
    inner class `askMovingToUser 메소드는` : NsTest() {

        @Nested
        inner class `실행하면` {
            private val readValues = listOf("A", "B", "C", "U")

            @Test
            fun `U나 D를 입력 받을 때까지 예외 메세지를 출력하며 반복한다`() {
                System.setIn(ByteArrayInputStream(readValues.joinToString("\n").toByteArray()))

                val moving = inputView.askMovingToUser()

                assertThat(output()).contains(ERROR_MESSAGE)
                assertThat(moving).isEqualTo("U")
            }
        }

        override fun runMain() {
            inputView.askMovingToUser()
        }
    }

    @Nested
    inner class `readGameCommand 메소드는` : NsTest() {

        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        @Nested
        inner class `R과 Q 이외의 값을 입력받으면` {
            private fun readValues() = listOf("A", "RQ")

            @ParameterizedTest
            @MethodSource("readValues")
            fun `예외 메세지와 함께 예외를 던진다`(readValue: String) {
                assertThatThrownBy { runException(readValue) }
                    .isInstanceOf(IllegalArgumentException::class.java)
                    .hasMessageContaining(ERROR_MESSAGE)
            }
        }

        @Nested
        inner class `R과 Q 중 하나의 값을 입력받으면`() {
            private val readValue = "Q"

            @Test
            fun `입력받은 값을 반환한다`() {
                System.setIn(ByteArrayInputStream(readValue.toByteArray()))

                val moving = inputView.readGameCommand()

                assertThat(moving).isEqualTo("Q")
            }
        }

        override fun runMain() {
            inputView.readGameCommand()
        }
    }

    @Nested
    inner class `askRetryToUser 메소드는` : NsTest() {

        @Nested
        inner class `실행하면` {
            private val readValues = listOf("A", "B", "C", "R")

            @Test
            fun `R이나 Q를 입력 받을 때까지 예외 메세지를 출력하며 반복한다`() {
                System.setIn(ByteArrayInputStream(readValues.joinToString("\n").toByteArray()))

                val retry = inputView.askRetryToUser()

                assertThat(output()).contains(ERROR_MESSAGE)
                assertThat(retry).isTrue
            }
        }

        @Nested
        inner class `사용자가 R을 입력하면` {
            private val readValue = "R"

            @Test
            fun `참을 반환한다`() {
                System.setIn(ByteArrayInputStream(readValue.toByteArray()))

                val retry = inputView.askRetryToUser()

                assertThat(retry).isTrue
            }
        }

        @Nested
        inner class `사용자가 Q를 입력하면` {
            private val readValue = "Q"

            @Test
            fun `거짓을 반환한다`() {
                System.setIn(ByteArrayInputStream(readValue.toByteArray()))

                val retry = inputView.askRetryToUser()

                assertThat(retry).isFalse
            }
        }

        override fun runMain() {
            inputView.askRetryToUser()
        }
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}