package bridge.model

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BridgeGameTest {
    private var _game: BridgeGame? = null
    private val game: BridgeGame get() = _game!!
    private val directions = listOf("U", "D", "D")

    @BeforeEach
    fun makeGame() {
        _game = BridgeGame(Bridge(directions))
    }

    @Test
    fun `플레이어가 건널 수 있는 방향으로 이동할 때 true를 리턴한다`() {
        val moving = directions
        assert(
            moving
                .map { game.move(it) }
                .all { true }
        )
    }

    @Test
    fun `플레이어가 건널 수 없는 방향으로 이동할 때 false를 리턴한다`() {
        val moving = listOf("U", "D", "U")
        assert(
            !moving
                .map { game.move(it) }
                .last()
        )
    }

    @Test
    fun `플레이어가 다리가 끝났는데도 이동하려하면 예외를 발생시킨다`() {
        val moving = directions
            .toMutableList()
            .apply { add("U") }
        assertThrows<IllegalStateException> {
            moving.forEach { game.move(it) }
        }
    }

    @Test
    fun `이동을 U나 D가 아닌 문자로 하려하면 예외를 발생시킨다`() {
        val moving = listOf("F")
        assertThrows<IllegalArgumentException> {
            moving.forEach { game.move(it) }
        }
    }

    @Test
    fun `재시도 여부를 알 수 있다`() {
        val commands = listOf("R", "Q")
        val expects = listOf(true, false)
        assert(
            commands.map { game.retry(it) } == expects
        )
    }

    @Test
    fun `재시도 여부를 R이나 Q가 아닌 문자로 판단할 때는 예외를 발생시킨다`() {
        val command = "HI"
        assertThrows<IllegalArgumentException> {
            game.retry(command)
        }
    }

    @Test
    fun `재시도 시에만 총 시도 횟수가 증가한다`() {
        val commands = listOf("R", "Q", "R", "Q", "Q")
        val expects = 3
        commands.forEach { game.retry(it) }
        assert(
            game.tryCount == expects
        )
    }

    @Test
    fun `플레이어가 다리를 모두 건넜는지 알 수 있어야 한다`() {
        val moving = directions
        game.move("U")
        assert(!game.isEnd())
        game.move("D")
        game.move("D")
        assert(game.isEnd())
    }
}