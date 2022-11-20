package bridge.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class StageTest {
    @Test
    fun `다리 건너기 게임의 스테이지 결과를 enum 클래스로 반환한다`() {
        assertThat(Stage.getStageInform("U", "O")).isEqualTo(Stage.UP)
    }
}