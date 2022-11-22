package bridge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BridgeGameTest {
    private val numberGenerator: BridgeNumberGenerator = ApplicationTest.TestNumberGenerator(listOf(1, 0, 0))
    private val bridgeMaker = BridgeMaker(numberGenerator).makeBridge(3)
    private val bridgeGame = BridgeGame(bridgeMaker)

    @Test
    fun `플레이어가 옳게 이동했을 때 다리 업데이트 테스트`() {
        bridgeGame.move("U")
        bridgeGame.move("D")
        bridgeGame.move("D")
        assertThat(bridgeGame.resultUpBridge).containsExactly("O", " ", " ")
    }

    @Test
    fun `플레이어가 잘못 이동했을 때 다리 업데이트 테스트`() {
        bridgeGame.move("U")
        bridgeGame.move("D")
        bridgeGame.move("U")
        assertThat(bridgeGame.resultUpBridge).containsExactly("O", " ", "X")
    }

    @Test
    fun `플레이어 이동 확인 테스트`() {
        bridgeGame.move("U")
        assertThat(bridgeGame.check()).isTrue
        bridgeGame.move("U")
        assertThat(bridgeGame.check()).isFalse
    }

    @Test
    fun `게임을 재시도 하는 경우 테스트`() {
        val prevCount = bridgeGame.playCount
        bridgeGame.retry()
        assertThat(bridgeGame.playCount == prevCount + 1)
    }

    @Test
    fun `다리를 마지막까지 선택한 경우 테스트`() {
        bridgeGame.move("U")
        bridgeGame.move("D")
        bridgeGame.move("D")
        assertThat(bridgeGame.over()).isTrue
    }

    @Test
    fun `다리를 아직 다 건너지 않은 경우 테스트`() {
        bridgeGame.move("U")
        bridgeGame.move("D")
        assertThat(bridgeGame.over()).isFalse
    }

    @Test
    fun `다리를 다 건너는데 성공한 경우 테스트`() {
        bridgeGame.move("U")
        bridgeGame.move("D")
        bridgeGame.move("D")
        assertThat(bridgeGame.over() && bridgeGame.check()).isTrue
    }

    @Test
    fun `마지막 다리 선택을 실패한 경우 테스트`() {
        bridgeGame.move("U")
        bridgeGame.move("D")
        bridgeGame.move("U")
        assertThat(bridgeGame.over() && bridgeGame.check()).isFalse
    }
}