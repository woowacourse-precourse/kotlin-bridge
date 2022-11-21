package bridge.domain

import bridge.data.Bridge
import bridge.data.BridgeMap
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BridgeGameTest(){
    private val bridgeGame =BridgeGame()
    @Test fun `moveTest`(){
        val result = "O"
        val bridge = Bridge(listOf("U","U","D"))
        assertThat(result).isEqualTo(bridgeGame.move(bridge,"U",BridgeMap()))
    }
}
