package bridge.domain

import bridge.Player
import bridge.resources.BRIDGE_BOTTOM_LINE_CHAR
import bridge.resources.BRIDGE_RETRY
import bridge.resources.BRIDGE_TOP_LINE_CHAR
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test

class BridgeMapTest {
    private val bridgeGame = BridgeGame()

    @Test
    fun `경로 이동 테스트 1, U 입력시 이동 경로 반영`() {
        val userRouteList = mutableListOf("U","U")
        bridgeGame.move(BRIDGE_TOP_LINE_CHAR, userRouteList)
        assertThat(userRouteList).isEqualTo(listOf("U","U","U"))
    }

    @Test
    fun `경로 이동 테스트 2, D 입력시 이동 경로 반영`() {
        val userRouteList = mutableListOf("U","U")
        bridgeGame.move(BRIDGE_BOTTOM_LINE_CHAR, userRouteList)
        assertThat(userRouteList).isEqualTo(listOf("U","U","D"))
    }

    @Test
    fun `게임 시도 횟수 테스트`() {
        val player = Player(bridgeGame)
        val inputString = BRIDGE_RETRY
        player.userSelectedRoute.addAll(listOf("U","U","D"))
        System.setIn(inputString.byteInputStream())
        player.setRetry()
        assertThat(player.tryCount).isEqualTo(2)
    }
}