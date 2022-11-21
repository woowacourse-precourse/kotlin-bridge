package bridge

import bridge.View.InputView
import bridge.computer.BridgeMaker
import bridge.computer.BridgeRandomNumberGenerator
import bridge.computer.ErrorCheck
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest {
    @Test
    fun `브릿지 사이즈가 지정된 범위를 넘어서면 예외가 발생한다 max`() {
        assertThrows<IllegalArgumentException> {
            BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(21)
        }
    }

    @Test
    fun `브릿지 사이즈가 지정된 범위를 넘어서면 예외가 발생한다 min`() {
        assertThrows<IllegalArgumentException> {
            BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(1)
        }
    }

    @Test
    fun `무브 값 입력 시 잘못된 문자를 넣으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            ErrorCheck().MoveKeyWordisDiffer("Z")
        }
    }

    @Test
    fun `재시작 값 입력 시 잘못된 문자를 넣으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            ErrorCheck().ReTrykeyWordld("Z")
        }
    }


}