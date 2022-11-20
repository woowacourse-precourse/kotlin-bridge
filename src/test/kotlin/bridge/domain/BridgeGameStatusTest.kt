package bridge.domain

import bridge.BridgeGameTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BridgeGameStatusTest {
    private var bridge = emptyList<String>()

    @BeforeEach
    fun beforeEach() {
        val numberGenerator: BridgeNumberGenerator = BridgeGameTest.TestNumberGenerator(listOf(1, 0, 0))
        bridge = BridgeMaker(numberGenerator).makeBridge(3)
    }

    @Test
    fun `모두 참이고 길이가 다르면 진행중이다`() {
        val stage = listOf(true, true)
        val bridgeGameInfo = BridgeGameInfo(bridge, stage, 1)
        assertThat(BridgeGameStatus.getStatus(bridgeGameInfo)).isEqualTo(BridgeGameStatus.RUNNING)
    }

    @Test
    fun `모두 참이고 길이가 같다면 성공이다`() {
        val stage = listOf(true, true, true)
        val bridgeGameInfo = BridgeGameInfo(bridge, stage, 1)
        assertThat(BridgeGameStatus.getStatus(bridgeGameInfo)).isEqualTo(BridgeGameStatus.SUCCESS)
    }

    @Test
    fun `마지막이 참이 아니면 실패다`() {
        val stage = listOf(true, true, false)
        val bridgeGameInfo = BridgeGameInfo(bridge, stage, 1)
        assertThat(BridgeGameStatus.getStatus(bridgeGameInfo)).isEqualTo(BridgeGameStatus.FAILURE)
    }

    @Test
    fun `마지막을 제외하고 false있으면 에러처리한다`() {
        val stage = listOf(true, false, true)
        val bridgeGameInfo = BridgeGameInfo(bridge, stage, 1)
        assertThrows<IllegalArgumentException> {
            BridgeGameStatus.getStatus(bridgeGameInfo)
        }
    }

    @Test
    fun `stage가 bridge 보다 크면 에러처리한다`() {
        val stage = listOf(true, false, true, true)
        val bridgeGameInfo = BridgeGameInfo(bridge, stage, 1)
        assertThrows<IllegalArgumentException> {
            BridgeGameStatus.getStatus(bridgeGameInfo)
        }
    }

    @Test
    fun `R을 입력하면 재시작이다`() {
        assertThat(BridgeGameStatus.setStatus("R")).isEqualTo(BridgeGameStatus.RETRY)
    }

    @Test
    fun `Q을 입력하면 게임을 끝낸다`() {
        assertThat(BridgeGameStatus.setStatus("Q")).isEqualTo(BridgeGameStatus.QUIT)
    }

    @ParameterizedTest(name = "나머지를 입력하면 에러처리한다 {argumentsWithNames}")
    @ValueSource(strings = ["RR", "D", "1", "A"])
    fun `나머지를 입력하면 에러처리한다`(command: String) {
        assertThrows<IllegalArgumentException> {
            BridgeGameStatus.setStatus(command)
        }
    }
}
