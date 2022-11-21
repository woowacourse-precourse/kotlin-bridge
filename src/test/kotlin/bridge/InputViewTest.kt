package bridge

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputViewTest {
    val inputView = InputView()

    @Nested
    inner class TestReadBridgeSize {
        @Test
        fun `숫자타입이 아닌입력 (알파벳)`() {
            assertThrows<IllegalArgumentException> { inputView.getValidateBridgeSize("A") }
        }

        @Test
        fun `숫자타입이 아닌입력 (알파벳 소문자)`() {
            assertThrows<IllegalArgumentException> { inputView.getValidateBridgeSize("a") }
        }

        @Test
        fun `숫자타입이 아닌입력 (한글)`() {
            assertThrows<IllegalArgumentException> { inputView.getValidateBridgeSize("ㄱ") }
        }

        @Test
        fun `숫자타입이 아닌입력 (특수문자)`() {
            assertThrows<IllegalArgumentException> { inputView.getValidateBridgeSize("-") }
        }
    }

    @Test
    fun readMoving() {
    }

    @Test
    fun readGameCommand() {
    }
}
