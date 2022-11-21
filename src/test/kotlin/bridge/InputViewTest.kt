package bridge

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat


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

    @Nested
    inner class TestReadMoving {
        @Test
        fun `소문자 정상 처리되는지 테스트(u)`() {
            assertThat(inputView.getValidateMovingCode("u")).isEqualTo("U")
        }

        @Test
        fun `소문자 정상 처리되는지 테스트(d)`() {
            assertThat(inputView.getValidateMovingCode("d")).isEqualTo("D")
        }

        @Test
        fun `대문자 정상 처리되는지 테스트(u)`() {
            assertThat(inputView.getValidateMovingCode("U")).isEqualTo("U")
        }

        @Test
        fun `대문자 정상 처리되는지 테스트(d)`() {
            assertThat(inputView.getValidateMovingCode("D")).isEqualTo("D")
        }

        @Test
        fun `u,d 이외의 알파벳 입력(소문자)`() {
            assertThrows<IllegalArgumentException> { inputView.getValidateMovingCode("a") }
        }

        @Test
        fun `u,d 이외의 알파벳 입력(대문자)`() {
            assertThrows<IllegalArgumentException> { inputView.getValidateMovingCode("B") }
        }

        @Test
        fun `한글 입력`() {
            assertThrows<IllegalArgumentException> { inputView.getValidateMovingCode("ㄱ") }
        }

        @Test
        fun `특수문자 입력`() {
            assertThrows<IllegalArgumentException> { inputView.getValidateMovingCode("!") }
        }
    }

    @Nested
    inner class TestReadGameCommand{
        @Test
        fun `소문자 정상 처리되는지 테스트(r)`() {
            assertThat(inputView.getValidateGameCommend("r")).isEqualTo("R")
        }

        @Test
        fun `소문자 정상 처리되는지 테스트(q)`() {
            assertThat(inputView.getValidateGameCommend("q")).isEqualTo("Q")
        }

        @Test
        fun `대문자 정상 처리되는지 테스트(R)`() {
            assertThat(inputView.getValidateGameCommend("R")).isEqualTo("R")
        }

        @Test
        fun `대문자 정상 처리되는지 테스트(Q)`() {
            assertThat(inputView.getValidateGameCommend("Q")).isEqualTo("Q")
        }

        @Test
        fun `r,q 이외의 알파벳 입력(소문자)`() {
            assertThrows<IllegalArgumentException> { inputView.getValidateGameCommend("a") }
        }

        @Test
        fun `r,q 이외의 알파벳 입력(대문자)`() {
            assertThrows<IllegalArgumentException> { inputView.getValidateGameCommend("B") }
        }

        @Test
        fun `한글 입력`() {
            assertThrows<IllegalArgumentException> { inputView.getValidateGameCommend("ㄱ") }
        }

        @Test
        fun `특수문자 입력`() {
            assertThrows<IllegalArgumentException> { inputView.getValidateGameCommend("!") }
        }
    }
}
