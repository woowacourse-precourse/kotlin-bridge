package bridge

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.junit.jupiter.api.DisplayName


class InputViewTest {
    @Test
    @DisplayName("입력값이 숫자일 때 정상적으로 입력받는다.")
    fun `readBridgeSize normal`() {
        assertSimpleTest {
            val bridgesize = InputView("3").readBridgeSize()
            assertThat(bridgesize).isEqualTo(3)
        }
    }
    @Test
    @DisplayName("입력값이 숫자가 아닐 때 예외를 발생시킨다.")
    fun `readBridgeSize exception !int`() {
        assertThrows<IllegalArgumentException> {
            InputView("a").readBridgeSize()
        }
    }
    @Test
    @DisplayName("입력값이 2일 때 예외를 발생시킨다.")
    fun `readBridgeSize exception 2`() {
        assertThrows<IllegalArgumentException> {
            InputView("2").readBridgeSize()
        }
    }
    @Test
    @DisplayName("입력값이 21일 때 예외를 발생시킨다.")
    fun `readBridgeSize exception 21`() {
        assertThrows<IllegalArgumentException> {
            InputView("21").readBridgeSize()
        }
    }
}