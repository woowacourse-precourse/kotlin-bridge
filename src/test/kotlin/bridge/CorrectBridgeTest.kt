package bridge

import org.junit.jupiter.api.Test

class CorrectBridgeTest {
    private val correctBridge = CorrectBridge

    @Test
    fun `다리 생성시 사이즈 테스트`(){
        correctBridge.createBridge(3)

    }
}