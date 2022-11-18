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

    @Test
    @DisplayName("입력값이 U일 때 정상적으로 입력받는다.")
    fun `readMovingDirection normal U`() {
        assertSimpleTest {
            val movingDirection = InputView("U").readMoving()
            assertThat(movingDirection).isEqualTo("U")
        }
    }
    @Test
    @DisplayName("입력값이 D일 때 정상적으로 입력받는다.")
    fun `readMovingDirection normal D`() {
        assertSimpleTest {
            val movingDirection = InputView("D").readMoving()
            assertThat(movingDirection).isEqualTo("D")
        }
    }
    @Test
    @DisplayName("입력값이 U, D가 아닐 때 예외를 발생시킨다.")
    fun `readMovingDirection exception !UD`() {
        assertThrows<IllegalArgumentException> {
            InputView("a").readMoving()
        }
    }
    @Test
    @DisplayName("입력값이 UU일 때 예외를 발생시킨다.")
    fun `readMovingDirection exception UU`() {
        assertThrows<IllegalArgumentException> {
            InputView("UU").readMoving()
        }
    }

    @Test
    @DisplayName("입력값이 R일 때 정상적으로 입력받는다.")
    fun `readGameCommand normal R`() {
        assertSimpleTest {
            val gameRestart = InputView("R").readGameCommand()
            assertThat(gameRestart).isEqualTo("R")
        }
    }
    @Test
    @DisplayName("입력값이 Q일 때 정상적으로 입력받는다.")
    fun `readGameCommand normal Q`() {
        assertSimpleTest {
            val gameQuit = InputView("Q").readGameCommand()
            assertThat(gameQuit).isEqualTo("Q")
        }
    }
    @Test
    @DisplayName("입력값이 R, Q가 아닐 때 예외를 발생시킨다.")
    fun `readGameCommand exception !RQ`() {
        assertThrows<IllegalArgumentException> {
            InputView("a").readGameCommand()
        }
    }
    @Test
    @DisplayName("입력값이 RR일 때 예외를 발생시킨다.")
    fun `readGameCommand exception RR`() {
        assertThrows<IllegalArgumentException> {
            InputView("RR").readGameCommand()
        }
    }
}