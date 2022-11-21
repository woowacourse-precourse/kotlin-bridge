package bridge

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class BridgeGameTest: NsTest() {
    @Test
    fun `건널 수 있는 다리인지 판별하는 테스트`() {
        val bridgeGame = BridgeGame(listOf("U", "D", "D", "U", "U"))
        bridgeGame.move("U")
        bridgeGame.move("D")
        val isMovable = bridgeGame.move("U")
        Assertions.assertThat(isMovable).isEqualTo(false)
    }

    override fun runMain() {
        TODO("Not yet implemented")
    }

}