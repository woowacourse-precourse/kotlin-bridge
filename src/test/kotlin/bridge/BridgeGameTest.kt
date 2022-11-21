package bridge

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.ByteArrayInputStream

class BridgeGameTest {
    private fun generateBridge(): List<String> {
        val numberGenerator: BridgeNumberGenerator = ApplicationTest.TestNumberGenerator(listOf(0, 1, 0, 0))
        val bridgeMaker = BridgeMaker(numberGenerator)
        return bridgeMaker.makeBridge(4)
    }

    @Test
    fun `다리 생성 테스트`() {
        val bridge = generateBridge()
        assertThat(bridge).containsExactly("D", "U", "D", "D")
    }

    @Test
    fun `다리 생성 길이 예외 테스트`() {
        val bridge = generateBridge()
        assertThat(bridge).hasSize(4)
    }


    @Test
    fun `유저 이동 테스트`() {
        val bridgeGame = BridgeGame()
        bridgeGame.makeBridge(Bridge(generateBridge()))
        bridgeGame.move("U")
        assertThat(bridgeGame.getUserStep()).containsExactly(Pair("U", false))
    }


    @Test
    fun `유저 이동 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            val bridgeGame = BridgeGame()
            bridgeGame.makeBridge(Bridge(generateBridge()))
            bridgeGame.move("F")
        }
    }

    @Test
    fun `재시도 테스트`() {
        assertThrows<IllegalStateException> {
            val bridgeGame = BridgeGame()
            bridgeGame.makeBridge(Bridge(generateBridge()))
            bridgeGame.retry()
        }
    }

    @Test
    fun `게임 클리어 테스트`() {
        val bridgeGame = BridgeGame()
        bridgeGame.makeBridge(Bridge(generateBridge()))
        bridgeGame.move("D")
        bridgeGame.move("U")
        bridgeGame.move("D")
        bridgeGame.move("D")
        assertThat(bridgeGame.hasStepDone() && !bridgeGame.hasFailedLastStep()).isTrue()
    }

    @Test
    fun `시도한 횟수 테스트`() {
        val bridgeGame = BridgeGame()
        bridgeGame.makeBridge(Bridge(generateBridge()))
        bridgeGame.move("D")
        bridgeGame.move("U")
        bridgeGame.move("D")
        bridgeGame.move("D")
        assertThat(bridgeGame.getRetryCount()).isEqualTo(1)
    }
}