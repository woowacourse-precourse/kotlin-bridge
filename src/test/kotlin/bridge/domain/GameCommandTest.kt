package bridge.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class GameCommandTest {
    @Test
    fun `getGameCommand 메서드에 게임 명령어를 나타내는 문자열을 인자로 주었을 때 그에 맞는 GameCommand 객체를 반환`() {
        val input = listOf("R", "Q")
        val result = input.map { GameCommand.getGameCommand(it) }
        assertThat(result).containsExactly(GameCommand.RESTART, GameCommand.QUIT)
    }

    @ValueSource(strings = ["A", "Z"])
    @ParameterizedTest
    fun `getGameCommand 메서드에 게임 명령어를 나타내는 문자열이 아닌 것을 인자로 주었을 때 예외 발생`(input: String) {
        assertThrows<IllegalArgumentException> {
            GameCommand.getGameCommand(input)
        }
    }
}