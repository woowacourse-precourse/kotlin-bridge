package bridge

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
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

    @Test
    fun `다리 길이가 3부터 20사이가 맞는 경우`() {
        assertDoesNotThrow {
            BridgeException.isValidBridgeSize("3")
        }
    }

    @Test
    fun `이동할 칸이 U또는 D가 아닌 경우`() {
        assertThrows<IllegalArgumentException> {
            BridgeException.isValidMoving("R")
        }
    }

    @Test
    fun `이동할 칸이 U또는 D가 맞는 경우`() {
        assertDoesNotThrow {
            BridgeException.isValidMoving("D")
        }
    }

}