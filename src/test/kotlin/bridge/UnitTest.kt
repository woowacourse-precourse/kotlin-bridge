package bridge

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class UnitTest : NsTest() {
    private val inputView = InputView()
    private val bridgeNumberGenerator = BridgeRandomNumberGenerator()
    private val bridgeMaker = BridgeMaker(bridgeNumberGenerator)

    @Test
    fun `다리 길이 입력값 범위 초과`() {
        {
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
        assertSimpleTest {
            run { "21" }
            Assertions.assertThat(output()).contains("[ERROR]")
        }
    }

    @Test
    fun `다리 생성 테스트`(){
        println(bridgeMaker.makeBridge(5))
    }

    override fun runMain() {
        TODO("Not yet implemented")
    }
}