package bridge.view

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
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
                Assertions.assertThatThrownBy { runException(readValue) }
                    .isInstanceOf(IllegalArgumentException::class.java)
                    .hasMessageContaining(ERROR_MESSAGE)
            }
        }

        override fun runMain() {
            inputView.readBridgeSize()
        }
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}