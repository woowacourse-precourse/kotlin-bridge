package bridge

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class BridgeGameTest: NsTest() {
    private val bridgeGame = BridgeGame(listOf("U", "D", "D", "U", "U"))
    @Test
    fun `건널 수 있는 다리인지 판별하는 테스트`() {
        bridgeGame.move("U")
        bridgeGame.move("U")
        val lastBridge = bridgeGame.up.last()
        Assertions.assertThat(lastBridge).isEqualTo(" X ")
    }
    @Test
    fun `게임의 진행 여부 판단`() {
        bridgeGame.move("U")
        bridgeGame.move("D")
        bridgeGame.move("D")
        bridgeGame.move("U")
        bridgeGame.move("U")
        val isContinue = bridgeGame.isGameContinue()
        Assertions.assertThat(isContinue).isEqualTo("SUCCESS")
    }
    @Test
    fun `게임 재시도`() {
        bridgeGame.move("U")
        bridgeGame.move("D")
        bridgeGame.move("D")
        bridgeGame.retry()
        Assertions.assertThat(bridgeGame.index).isEqualTo(0)
    }
    override fun runMain() {
    }

}