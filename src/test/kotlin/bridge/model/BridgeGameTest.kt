package bridge.model

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BridgeGameTest {
    private var _game: BridgeGame? = null
    private val game: BridgeGame get() = _game!!
    private val directions = listOf("U", "D", "D")

    @BeforeEach
    private fun makeGame() {
        _game = BridgeGame(Bridge(directions))
    }

    @Test
    fun `플레이어가 건널 수 있는 방향으로 이동하면 게임 상태는 ONGOING 이다`() {
        val moving = "U"
        game.move(moving)
        assert(game.state == BridgeGameState.ONGOING)
    }

    @Test
    fun `플레이어가 건널 수 없는 방향으로 이동하면 게임 상태는 FAIL 이다`() {
        val moving = "D"
        game.move(moving)
        assert(game.state == BridgeGameState.FAIL)
    }

    @Test
    fun `플레이어가 다리를 모두 건넜다면 상태는 PASS 이다`() {
        setGameEnd()
        assert(game.state == BridgeGameState.PASS)
    }

    @Test
    fun `플레이어가 다리가 끝났는데도 이동하려하면 예외를 발생시킨다`() {
        setGameEnd()
        assertThrows<IllegalStateException> {
            game.move("U")
        }
    }

    @Test
    fun `재시도 시 총 시도 횟수가 1 증가한다`() {
        val beforeTryCount = game.tryCount
        setGameEnd()
        game.retry("R")
        val afterTryCount = game.tryCount
        assert(
            afterTryCount - beforeTryCount == 1
        )
    }

    @Test
    fun `이동 과정과 성공 여부를 기록해야 한다`() {
        setGameEnd()
        val expects = directions.map {
            BridgeGame.MovingResult(Direction.getByDisplayName(it), true)
        }
        assert(game.movingTrace == expects)
    }

    private fun setGameEnd() {
        directions.forEach { game.move(it) }
    }
}
