package bridge

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class CorrectBridgeTest {
    private val correctBridge = CorrectBridge

    @Test
    fun `다리 생성시 사이즈 테스트`(){
        correctBridge.createBridge(3)
        assertThat(correctBridge.correctBridge.size).isEqualTo(3)
    }
}