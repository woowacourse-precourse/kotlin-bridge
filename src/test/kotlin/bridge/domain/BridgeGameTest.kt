package bridge.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BridgeGameTest {
    private val bridgeGame = BridgeGame(listOf("U", "D", "U", "D"))

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `사용자가 이동한 다리의 정답 여부 확인`(position: Int) {
        assertThat(
            bridgeGame.move("D", position)
        ).isEqualTo(position % 2 != 0)
    }

}