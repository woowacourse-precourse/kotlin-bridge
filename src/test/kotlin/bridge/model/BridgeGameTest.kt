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
    fun `플레이어가 건널 수 있는 방향으로 이동하면 게임 상태는 ONGOING 이다`() {
        val moving = "U"
        game.move(moving)
        assert(game.state == BridgeGame.State.ONGOING)
    }

    @Test
    fun `플레이어가 건널 수 없는 방향으로 이동하면 게임 상태는 FAIL 이다`() {
        val moving = "D"
        game.move(moving)
        assert(game.state == BridgeGame.State.FAIL)
    }

    @Test
    fun `플레이어가 다리를 모두 건넜다면 상태는 PASS 이다`() {
        val moving = directions
        moving.forEach { game.move(it) }
        assert(game.state == BridgeGame.State.PASS)
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
    fun `게임이 이미 종료되었는데도 이동하려하면 예외를 발생시킨다`() {
        val moving = directions
        moving.forEach { game.move(it) }
        assertThrows<IllegalStateException> {
            game.move("U")
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
    fun `이동 과정을 기록해야 한다`() {
        val moving = directions
        moving.forEach { game.move(it) }
        assert(game.movingTrace == moving)
    }
}