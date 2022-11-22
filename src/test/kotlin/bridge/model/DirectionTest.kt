package bridge.model

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class DirectionTest {
    @Test
    fun `이동 방향은 1이면 위 칸 0이면 아래 칸이다`() {
        val inputs = listOf(0, 1)
        val results = inputs.map { Direction.getByValue(it) }
        val expects = listOf(Direction.DOWN, Direction.UP)
        assert(results == expects)
    }

    @ValueSource(ints = [-1, -2, -999, 2, 3])
    @ParameterizedTest
    fun `이동 방향을 0과 1이 아닌 수로 만들려고 하면 예외를 발생시킨다`(input: Int) {
        assertThrows<IllegalArgumentException> {
            Direction.getByValue(input)
        }
    }

    @Test
    fun `이동 방향은 U이면 위 칸, D이면 아래 칸이다`() {
        val inputs = listOf("U", "D")
        val results = inputs.map { Direction.getByCommand(it) }
        val expects = listOf(Direction.UP, Direction.DOWN)
        assert(results == expects)
    }

    @ValueSource(strings = ["0", "HI", "1", "F", "가", "u", "d"])
    @ParameterizedTest
    fun `이동 방향을 대문자 U와 D가 아닌 문자로 만들려고 하면 예외를 발생시킨다`(input: String) {
        assertThrows<IllegalArgumentException> {
            Direction.getByCommand(input)
        }
    }
}
