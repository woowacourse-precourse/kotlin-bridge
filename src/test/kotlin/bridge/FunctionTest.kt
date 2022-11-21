package bridge
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class FunctionTest {
    @Test
    fun `방향 입력값 체크`() {
        assertThrows<IllegalArgumentException> {
            ExceptionCheck.checkDirection("a")
        }
    }

    @Test
    fun `readBridgeSize()`() {
        assertThrows<IllegalArgumentException> {
            ExceptionCheck.checkBridgeSize("1")
        }
    }
}
