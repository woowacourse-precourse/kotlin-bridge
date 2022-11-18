package bridge.domain

import bridge.BridgeGame
import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import bridge.Exception.MoveException
import bridge.resources.DOWN
import bridge.resources.UP
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class MoveInputTest {
    @Test
    fun `moveInput에 null이 들어갈 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            MoveException.exceptions("")
        }
    }

    @Test
    fun `moveInput가 한 글자가 아닌 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            MoveException.exceptions("UD")
        }
    }

    @Test
    fun `moveInput가 U나 D가 아닌 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            MoveException.exceptions("Z")
        }
        assertThrows<IllegalArgumentException> {
            MoveException.exceptions("2")
        }
    }
}