package bridge

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UnitTest {
    private val inputView = InputView()
    private val bridgeNumberGenerator = BridgeRandomNumberGenerator()
    private val bridgeMaker = BridgeMaker(bridgeNumberGenerator)

    @Test
    fun `다리 길이 입력값 범위 초과`() {
        assertThrows<IllegalArgumentException> {
            inputView.readBridgeSize()
        }
    }

    @Test
    fun `다리 길이 입력값 범위 미달`() {
        inputView.readBridgeSize()
    }

    @Test
    fun `다리 길이 입력값 예외`() {
        inputView.readBridgeSize()
    }

    @Test
    fun `이동 입력값 예외`() {
        inputView.readMoving()
    }

    @Test
    fun `다리 생성 테스트`(){
        println(bridgeMaker.makeBridge(5))
    }
}