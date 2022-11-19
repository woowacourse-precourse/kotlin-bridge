package bridge

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UnitTest {
    private val inputView = InputView()

    @Test
    fun `다리 길이 입력값 범위 초과`() {
        assertThrows<IllegalArgumentException> {
            inputView.readBridgeSize("93")
        }
    }

    @Test
    fun `다리 길이 입력값 범위 미달`() {
        inputView.readBridgeSize("1")
    }

    @Test
    fun `다리 길이 입력값 예외`() {
        inputView.readBridgeSize("안녕")
    }
}