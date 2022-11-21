package bridge.ui.view

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class InputViewTest {
    private lateinit var inputView: InputView

    @BeforeEach
    fun setUp() {
        // Given
        inputView = InputView()
    }

    @Test
    fun `사용자가 다리 길이를 잘 입력 받는지 테스트`() {
        inputView.readBridgeSize()
    }
}