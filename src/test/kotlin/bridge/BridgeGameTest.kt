package bridge

import bridge.domain.Bridge
import bridge.domain.BridgeGame
import bridge.domain.User
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BridgeGameTest {

    val bridgeGame = BridgeGame()
    val movingMatchResults = listOf<Pair<String,Boolean>>(Pair("U",true),Pair("U",false),Pair("D",true),Pair("D",false))
    val user = User(mutableListOf(),"U",0,0)
    val bridge = Bridge(listOf("U","D","U"))

    @Test
    fun `사용자가 위에 건넌 다리 upperMap 기능 테스트`(){
        val upperMap = bridgeGame.getUpperMap(movingMatchResults)
        assertThat(upperMap).isEqualTo("[ O | X |   |   ]")
    }

    @Test
    fun `사용자가 아래 건넌 다리 lowerMap 기능 테스트`(){
        val lowerMap = bridgeGame.getLowerMap(movingMatchResults)
        assertThat(lowerMap).isEqualTo("[   |   | O | X ]")
    }

    @Test
    fun `사용자가 건넌 다리 모든 map 기능 테스트`(){
        val map = bridgeGame.getMap(movingMatchResults)
        assertThat(map).isEqualTo("[ O | X |   |   ]\n[   |   | O | X ]")
    }

    @Test
    fun `게임 성공 여부 테스트`(){
        val result = bridgeGame.getGameResult(bridge,user)
        assertThat(result).isEqualTo(BridgeGame.GameResult.CONTINUE)
    }
}