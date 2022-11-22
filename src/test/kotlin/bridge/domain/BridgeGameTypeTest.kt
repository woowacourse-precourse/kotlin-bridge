package bridge.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BridgeGameTypeTest {
    @Test
    fun `1을 입력하면 UP이 나온다`() {
        assertThat(BridgeGameType.of(1)).isEqualTo(BridgeGameType.UP)
    }

    @Test
    fun `0을 입력하면 DOWN이 나온다`() {
        assertThat(BridgeGameType.of(0)).isEqualTo(BridgeGameType.DOWN)
    }

    @ParameterizedTest(name = "R와 Q를 제외한 문자를 입력하면 에러처리한다 {argumentsWithNames}")
    @ValueSource(ints = [-1, 2, 3])
    fun `1와 0을 제외한 값을 입력하면 에러처리한다`(command: Int) {
        assertThrows<IllegalArgumentException> {
            BridgeGameType.of(command)
        }
    }
}
