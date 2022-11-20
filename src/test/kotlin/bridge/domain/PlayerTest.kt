package bridge.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class PlayerTest {
    private val player = Player(Bridge(listOf<String>("U", "D", "U")))

    @ValueSource(strings = ["U"])
    @ParameterizedTest
    fun `스테이지 진행 결과를 열거형 객체로 저장한다`(inputMoving: String) {
        player.updateStage(inputMoving)
        assertThat(player.getPlayerBridge()).containsExactly(Stage.UP)
    }
}