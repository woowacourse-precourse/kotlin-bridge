package bridge.domain

import bridge.main
import bridge.resources.BRIDGE_QUIT
import bridge.resources.BRIDGE_RETRY
import bridge.view.InputView
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BridgeUserInputTest: NsTest() {
    private val bridgeGame = BridgeGame()

    @Test
    fun `유저 입력 테스트 1, 실패하는 경우 R 입력시 재시작`() {
        val inputString = BRIDGE_RETRY
        System.setIn(inputString.byteInputStream())
        assertThat(bridgeGame.retry()).isEqualTo(true)
    }

    @Test
    fun `유저 입력 테스트 2, 실패하는 경우 Q 입력시 종료`() {
        val inputString = BRIDGE_QUIT
        System.setIn(inputString.byteInputStream())
        assertThat(bridgeGame.retry()).isEqualTo(false)
    }

    @Test
    fun `유저 입력 테스트 3, 실패하는 경우 R과 Q 이외 입력시 예외처리`() {
        assertThrows<IllegalArgumentException> {
            val inputString = "100"
            System.setIn(inputString.byteInputStream())
            InputView().inputRetry()
        }
    }

    @Test
    fun `유저 입력 테스트 4, 다음 칸 입력하는 경우, U와 D이외 입력시 예외처리`() {
        assertThrows<IllegalArgumentException> {
            val inputString = "100"
            System.setIn(inputString.byteInputStream())
            InputView().inputMoving()
        }
    }

    override fun runMain() {
        main()
    }
}