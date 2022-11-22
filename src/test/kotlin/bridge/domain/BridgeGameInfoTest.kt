package bridge.domain

import bridge.ApplicationTest
import bridge.BridgeMaker
import bridge.BridgeNumberGenerator
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BridgeGameInfoTest {
    private var bridge = emptyList<String>()

    @BeforeEach
    fun beforeEach() {
        val numberGenerator: BridgeNumberGenerator = ApplicationTest.TestNumberGenerator(listOf(1, 0, 0, 0, 0))
        bridge = BridgeMaker(numberGenerator).makeBridge(5)
    }

    @Test
    fun `진행 상황에 맞춰서 다리 상태를 잘 반환한다`() {
        val stage = listOf(true, true, false)
        val bridgeGameInfo = BridgeGameInfo(bridge, stage, 1)
        Assertions.assertThat(bridgeGameInfo.getBridge(BridgeGameType.UP)).isEqualTo(listOf("O", " ", " "))
        Assertions.assertThat(bridgeGameInfo.getBridge(BridgeGameType.DOWN)).isEqualTo(listOf(" ", "O", "X"))
    }
}
