package bridge

import bridge.exception.CheckException
import bridge.exception.PrintException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class BridgeTest {


    @Test
    fun `다리 길이 입력값이 숫자이고 올바른 범위인지 확인`() {
        assertThrows<IllegalArgumentException> {
            CheckException().checkInputSize("20")
        }
    }

    @Test
    fun `다리 생성 확인`() {
        var bridgeTest = PrintException().printBridge(3)
        assertEquals(bridgeTest.size,3)
        println(bridgeTest)
    }

    @Test
    fun `이동할 칸이 올바른 입력인지 확인`() {
        assertThrows<IllegalArgumentException> {
            CheckException().checkInputDirection("a")
        }
    }

    @Test
    fun `재시작 여부가 올바른 입력인지 확인`() {
        assertThrows<IllegalArgumentException> {
            CheckException().checkInputRestart("a")
        }
    }



}