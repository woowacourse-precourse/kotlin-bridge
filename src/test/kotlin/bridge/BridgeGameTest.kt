package bridge

import bridge.BridgeGame.Companion.MOVING_DIRECT_UP
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BridgeGameTest {
    private val bridgeGame = BridgeGame(
        BridgeMaker(
            BridgeRandomNumberGenerator()
        )
    )

    @Test
    fun `게임 시작 테스트`() {
        bridgeGame.start(10)
        val field = getPrivateField("bridge")
        field.trySetAccessible()
        val bridge = field.get(bridgeGame) as List<*>
        assertThat(bridge.size).isEqualTo(10)
    }

    @Test
    fun `칸 이동 테스트`() {
        bridgeGame.start(3)
        val field = getPrivateField("bridge")
        field.trySetAccessible()
        val bridge = field.get(bridgeGame) as List<*>
        move(bridge)
    }

    private fun move(bridge: List<*>) {
        bridge.forEachIndexed { index, any ->
            if (any == MOVING_DIRECT_UP) {
                assertThat(bridgeGame.move(index, MOVING_DIRECT_UP))
                    .isEqualTo(Pair('O', MOVING_DIRECT_UP))
            } else {
                assertThat(bridgeGame.move(index, MOVING_DIRECT_UP))
                    .isEqualTo(Pair('X', MOVING_DIRECT_UP))
            }
        }
    }

    @Test
    fun `게임 시도 횟수 테스트`() {
        bridgeGame.start(3)
        assertThat(bridgeGame.getPlayCount()).isEqualTo(1)
        bridgeGame.retry()
        assertThat(bridgeGame.getPlayCount()).isEqualTo(2)
    }

    private fun getPrivateField(fieldName: String) = BridgeGame::class.java.getDeclaredField(fieldName)
}