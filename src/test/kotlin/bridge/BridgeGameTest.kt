package bridge

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BridgeGameTest : NsTest() {

    @Test
    fun `다리 건너기 성공 테스트`() {
        initGame()
        BridgeMaker.bridge.add("U")
        BridgeMaker.bridge.add("U")
        BridgeMaker.bridge.add("D")
        tryCount = 0
        assertSimpleTest {
            assertThat(BridgeGame().move("U"))
        }
    }

    @Test
    fun `다리 건너기 실패 테스트`() {
        initGame()
        BridgeMaker.bridge.add("U")
        BridgeMaker.bridge.add("U")
        BridgeMaker.bridge.add("D")
        tryCount = 0
        assertSimpleTest {
            assertThat(!BridgeGame().move("D"))
        }
    }

    fun initGame() {
        BridgeMaker.bridge.clear()
        BridgeGame.upBridge.clear()
        BridgeGame.downBridge.clear()
        order = 0
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}