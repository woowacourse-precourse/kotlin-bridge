package bridge.verifier

import bridge.views.InputView
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class VerifierTest {
    @Test
    fun `다리 길이 예외 처리 테스트 1`() {
        val inputView = InputView()
        assertThrows<IllegalArgumentException> { inputView.checkBridgeLength("8a") }
    }

    @Test
    fun `다리 길이 예외 처리 테스트 2`() {
        val inputView = InputView()
        assertThrows<IllegalArgumentException> { inputView.checkBridgeLength("23") }
    }

    @Test
    fun `다리 길이 예외 처리 테스트 3`() {
        val inputView = InputView()
        assertThrows<IllegalArgumentException> { inputView.checkBridgeLength("2") }
    }

    @Test
    fun `이동할 칸 입력 테스트`() {
        val inputView = InputView()
        assertThrows<IllegalArgumentException> { inputView.checkMoving("h") }
    }

    @Test
    fun `재시작 여부 입력 테스트`() {
        val inputView = InputView()
        assertThrows<IllegalArgumentException> { inputView.checkGameRetry("h") }
    }


}