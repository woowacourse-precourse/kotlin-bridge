package bridge

import bridge.computer.BridgeMaker
import bridge.computer.BridgeRandomNumberGenerator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest {
    @Test
    fun `브릿지 사이즈가 지정된 범위를 넘어서면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(21)
        }
    }
}