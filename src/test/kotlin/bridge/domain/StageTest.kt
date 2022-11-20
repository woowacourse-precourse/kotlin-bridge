package bridge.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class StageTest {
    @Test
    fun `다리 건너기 게임의 스테이지 결과를 enum 클래스로 반환한다`() {
        assertThat(Stage.getStageInform("U", "O")).isEqualTo(Stage.UP)
    }

    @Test
    fun `위와 아래 중 플레이어의 기록과 다른 쪽으로 건넜을 경우 공백을 반환한다`() {
        assertThat(Stage.makeUpBridgeMap(Stage.DOWN)).isEqualTo(" ")
        assertThat(Stage.makeDownBridgeMap(Stage.UP)).isEqualTo(" ")
    }

    @Test
    fun `다리를 성공적으로 건넜다면 O를 반환한다`() {
        assertThat(Stage.makeUpBridgeMap(Stage.UP)).isEqualTo("O")
        assertThat(Stage.makeDownBridgeMap(Stage.DOWN)).isEqualTo("O")
    }

    @Test
    fun `다리를 건너는데 실패했다면 X를 반환한다`() {
        assertThat(Stage.makeUpBridgeMap(Stage.UP_FAIL)).isEqualTo("X")
        assertThat(Stage.makeDownBridgeMap(Stage.DOWN_FAIL)).isEqualTo("X")
    }
}