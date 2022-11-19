package bridge

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class BridgeExceptionTest {

    @Test
    fun `다리 길이가 3부터 20사이가 아닌 경우`() {
        assertThrows<IllegalArgumentException> {
            BridgeException.isValidBridgeSize("21")
        }
    }

    @Test
    fun `다리 길이가 숫자가 아닌 경우`() {
        assertThrows<IllegalArgumentException> {
            BridgeException.isValidBridgeSize("3a")
        }
    }
}