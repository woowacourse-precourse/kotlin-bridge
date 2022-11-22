package bridge.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class DirectionTest {
    @Test
    fun `getDirection 메서드에 방향을 나타내는 문자열을 인자로 주었을 때 그에 맞는 Direction 객체를 반환`() {
        val input = listOf("U", "D")
        val result = input.map { Direction.getDirection(it) }
        assertThat(result).containsExactly(Direction.UP, Direction.DOWN)
    }

    @ValueSource(strings = ["A", "Z"])
    @ParameterizedTest
    fun `getDirection 메서드에 방향을 나타내는 문자열이 아닌 것을 인자로 주었을 때 예외 발생`(input: String) {
        assertThrows<IllegalArgumentException> {
            Direction.getDirection(input)
        }
    }

    @Test
    fun `getDirection 메서드에 방향을 나타내는 숫자를 인자로 주었을 때 그에 맞는 Direction 객체를 반환`() {
        val input = listOf(0, 1)
        val result = input.map { Direction.getDirection(it) }
        assertThat(result).containsExactly(Direction.DOWN, Direction.UP)
    }

    @ValueSource(ints = [-1, 2])
    @ParameterizedTest
    fun `getDirection 메서드에 방향을 나타내는 숫자가 아닌 것을 인자로 주었을 때 예외 발생`(input: Int) {
        assertThrows<IllegalArgumentException> {
            Direction.getDirection(input)
        }
    }
}