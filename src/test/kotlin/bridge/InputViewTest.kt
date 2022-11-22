package bridge

import bridge.exception.BridgeException
import bridge.presentation.InputView
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class InputViewTest: NsTest() {
    @Test
    fun `다리 개수 테스트`() {
        val bridgeSize = BridgeException("12").toSize()
        Assertions.assertThat(bridgeSize).isEqualTo(12)
    }
    @Test
    fun `다리 개수 예외 테스트`() {
        runException("12345", "3")
        InputView().readBridgeSize()
        assertSimpleTest {
            Assertions.assertThat(output()).contains("[ERROR]")
        }
    }
    @Test
    fun `다리 이동 입력칸 테스트`() {
        val bridgeMoving = BridgeException("U").toMoving()
        Assertions.assertThat(bridgeMoving).isEqualTo("U")
    }
    @Test
    fun `다리 이동 입력칸 예외 테스트`() {
        runException("Uri", "U")
        InputView().readMoving()
        assertSimpleTest {
            Assertions.assertThat(output()).contains("[ERROR]")
        }
    }
    @Test
    fun `재시작 입력 테스트`() {
        val bridgeMoving = BridgeException("R").toGameCommand()
        Assertions.assertThat(bridgeMoving).isEqualTo("R")
    }
    @Test
    fun `재시작 입력 예외 테스트`() {
        runException(null, "Q")
        InputView().readGameCommand()
        assertSimpleTest {
            Assertions.assertThat(output()).contains("[ERROR]")
        }
    }

    override fun runMain() {
    }
}