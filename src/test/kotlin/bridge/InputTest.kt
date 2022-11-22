package bridge

import bridge.view.Validator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputTest {
    private val validator = Validator()
    @Test
    fun `다리 길이 입력이 숫자가 아닐 때 `() {
        assertThrows<IllegalArgumentException> {
            validator.validateBridgeSize("와")
        }
    }

    @Test
    fun `다리 길이 입력이 3미만 20초과일 때 `() {
        assertThrows<IllegalArgumentException> {
            validator.validateBridgeSize("1")
        }
    }

    @Test
    fun `움직임 입력이 U 또는 D가 아닌 값일 때`() {
        assertThrows<IllegalArgumentException> {
            validator.validatorMove("E")
        }
    }

    @Test
    fun `게임이 끝날을 때 Q 또는 R이 아닌 값일 때`() {
        assertThrows<IllegalArgumentException> {
            validator.validatorGameCommand("d")
        }
    }

}