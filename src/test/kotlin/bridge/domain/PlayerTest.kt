package bridge.domain

import bridge.ApplicationTest
import bridge.util.BridgeNumberGenerator
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class PlayerTest {

    @BeforeEach
    fun setUp() {
        val numberGenerator: BridgeNumberGenerator = ApplicationTest.TestNumberGenerator(listOf(1, 0, 0))
        val bridgeMaker = BridgeMaker(numberGenerator)
        bridge = bridgeMaker.makeBridge(3)
    }

    @ParameterizedTest
    @CsvSource("U,O,0", "D,O,1", "U,X,2")
    @DisplayName("만들어진 다리에서 지나갈 다리가 멀쩡한지 확인하는 테스트")
    fun `플레이어가_다리를_지날수_있는_확인`(move: String, pathCheck: String, index: Int) {
        player.go(move, bridge)
        Assertions.assertThat(pathCheck).isEqualTo(player.getState()[index])
    }

    companion object {
        private lateinit var bridge: List<String>
        val player = Player()
    }
}
