package bridge.model

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class DirectionTest {
    @Test
    fun `이동 방향은 1이면 위 칸 0이면 아래 칸이다`() {
        val inputs = listOf(0, 1)
        val results = inputs.map { Direction.getByValue(it) }
        val expects = listOf(Direction.DOWN, Direction.UP)
        assert(results == expects)
    }

    @Test
    fun `이동 방향을 0과 1이 아닌 수로 만들려고 하면 예외를 발생시킨다`() {
        val input = -1
        assertThrows<IllegalArgumentException> {
            Direction.getByValue(input)
        }
    }

    @Test
    fun `이동 방향은 U이면 위 칸, D이면 아래 칸이다`() {
        val inputs = listOf("U", "D")
        val results = inputs.map { Direction.getByDisplayName(it) }
        val expects = listOf(Direction.UP, Direction.DOWN)
        assert(results == expects)
    }

    @Test
    fun `이동 방향을 U와 D가 아닌 문자로 만들려고 하면 예외를 발생시킨다`() {
        val input = "0"
        assertThrows<IllegalArgumentException> {
            Direction.getByDisplayName(input)
        }
    }
}
