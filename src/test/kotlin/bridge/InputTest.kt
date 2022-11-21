package bridge

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputTest {
    @Test
    fun `다리 길이 정수 확인`() {
        assertThrows<IllegalArgumentException> {
            BridgeSizeException("1.1")
        }
    }

    @Test
    fun `다리 길이 예외 확인`() {
        assertThrows<IllegalArgumentException> {
            BridgeSizeException("21")
        }
    }

    @Test
    fun `다리 이동 예외 확인`() {
        assertThrows<IllegalArgumentException> {
            BridgeMoveException("A")
        }
    }

    @Test
    fun `게임 재시작 및 종료 예외 확인`() {
        assertThrows<IllegalArgumentException> {
            GameCommandException("A")
        }
    }
}