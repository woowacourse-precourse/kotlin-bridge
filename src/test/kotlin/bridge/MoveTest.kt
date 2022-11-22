package bridge

import bridge.model.Bridge
import bridge.model.BridgeGame
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import bridge.utils.Constants.FAIL_SYMBOL
import bridge.utils.Constants.SUCCESS_SYMBOL
import bridge.utils.Constants.EMPTY_SYMBOL
import bridge.utils.Constants.UP_SYMBOL
import bridge.utils.Constants.DOWN_SYMBOL
import org.junit.jupiter.api.AfterEach

class MoveTest {
    val bridge = Bridge(listOf(UP_SYMBOL, DOWN_SYMBOL, UP_SYMBOL))

    @AfterEach
    fun `bridge 이동 칸 횟수 초기화`(){
        bridge.initializeLaneCount()
    }

    @Test
    fun `유효한 칸 이동에 성공했으면 true 를 반환한다`(){
        assertThat(bridge.isLaneAvailable(UP_SYMBOL)).isTrue
    }

    @Test
    fun `유효한 칸 이동에 실패했으면 false 를 반환한다`(){
        val bridgeGame = BridgeGame()
        bridgeGame.move(UP_SYMBOL, bridge)
        assertThat(bridge.isLaneAvailable(UP_SYMBOL)).isFalse
    }

    @Test
    fun `유효한 칸 이동에 성공했을 때 각 칸에 성공, 빈 심볼을 저장한다`(){
        val bridgeGame = BridgeGame()
        bridgeGame.move(UP_SYMBOL, bridge)
        assertThat(bridgeGame.upLane).isEqualTo(listOf(SUCCESS_SYMBOL))
        assertThat(bridgeGame.downLane).isEqualTo(listOf(EMPTY_SYMBOL))
    }

    @Test
    fun `유효한 칸 이동에 실패했을 때 각 칸에 실패, 빈 심볼을 저장한다`(){
        val bridgeGame = BridgeGame()
        bridgeGame.move(UP_SYMBOL, bridge)
        bridgeGame.move(UP_SYMBOL, bridge)
        assertThat(bridgeGame.upLane).isEqualTo(listOf(SUCCESS_SYMBOL, FAIL_SYMBOL))
        assertThat(bridgeGame.downLane).isEqualTo(listOf(EMPTY_SYMBOL, EMPTY_SYMBOL))
    }
}