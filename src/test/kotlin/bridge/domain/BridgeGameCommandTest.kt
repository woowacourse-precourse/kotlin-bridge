package bridge.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BridgeGameCommandTest {
    @Test
    fun `R을 입력하면 재시작이다`() {
        assertThat(BridgeGameCommand.of("R")).isEqualTo(BridgeGameCommand.RETRY)
    }

    @Test
    fun `Q을 입력하면 게임을 끝낸다`() {
        assertThat(BridgeGameCommand.of("Q")).isEqualTo(BridgeGameCommand.QUIT)
    }

    @ParameterizedTest(name = "R와 Q를 제외한 문자를 입력하면 에러처리한다 {argumentsWithNames}")
    @ValueSource(strings = ["RR", "D", "1", "A"])
    fun `나머지를 입력하면 에러처리한다`(command: String) {
        assertThrows<IllegalArgumentException> {
            BridgeGameCommand.of(command)
        }
    }
}
