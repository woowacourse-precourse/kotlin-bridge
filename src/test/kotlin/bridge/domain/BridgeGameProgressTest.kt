package bridge.domain

import bridge.ApplicationTest
import bridge.BridgeMaker
import bridge.BridgeNumberGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BridgeGameProgressTest {
    private var bridge = emptyList<BridgeGameType>()

    @BeforeEach
    fun beforeEach() {
        val numberGenerator: BridgeNumberGenerator = ApplicationTest.TestNumberGenerator(listOf(1, 0, 0))
        bridge = BridgeMaker(numberGenerator).makeBridge(3)
    }

    @Test
    fun `모두 참이고 길이가 다르면 진행중이다`() {
        val stage = listOf(true, true)
        val bridgeGameInfo = BridgeGameInfo(bridge, stage, 1)
        assertThat(BridgeGameProgress.of(bridgeGameInfo)).isEqualTo(BridgeGameProgress.RUNNING)
    }

    @Test
    fun `모두 참이고 길이가 같다면 성공이다`() {
        val stage = listOf(true, true, true)
        val bridgeGameInfo = BridgeGameInfo(bridge, stage, 1)
        assertThat(BridgeGameProgress.of(bridgeGameInfo)).isEqualTo(BridgeGameProgress.SUCCESS)
    }

    @Test
    fun `마지막이 참이 아니면 실패다`() {
        val stage = listOf(true, true, false)
        val bridgeGameInfo = BridgeGameInfo(bridge, stage, 1)
        assertThat(BridgeGameProgress.of(bridgeGameInfo)).isEqualTo(BridgeGameProgress.FAILURE)
    }

    @Test
    fun `마지막을 제외하고 false있으면 에러처리한다`() {
        val stage = listOf(true, false, true)
        val bridgeGameInfo = BridgeGameInfo(bridge, stage, 1)
        assertThrows<IllegalArgumentException> {
            BridgeGameProgress.of(bridgeGameInfo)
        }
    }

    @Test
    fun `stage가 bridge 보다 크면 에러처리한다`() {
        val stage = listOf(true, false, true, true)
        val bridgeGameInfo = BridgeGameInfo(bridge, stage, 1)
        assertThrows<IllegalArgumentException> {
            BridgeGameProgress.of(bridgeGameInfo)
        }
    }
}
