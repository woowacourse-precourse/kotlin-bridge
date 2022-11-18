package bridge.domain

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import bridge.Exception.BridgeLengthException
import bridge.resources.DOWN
import bridge.resources.UP
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException


class LengthInputTest {
    @Test
    fun `다리 길이에 null이 들어갈 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            BridgeLengthException.exceptions("")
        }
    }

    @Test
    fun `다리 길이에 숫자가 아닌 문자가 들어갈 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            BridgeLengthException.exceptions("12abc12")
        }
    }

    @Test
    fun `다리 길이에 3이상 20이하가 아닌 숫자가 들어갈 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            BridgeLengthException.exceptions("21")
        }
        assertThrows<IllegalArgumentException> {
            BridgeLengthException.exceptions("2")
        }
    }
}