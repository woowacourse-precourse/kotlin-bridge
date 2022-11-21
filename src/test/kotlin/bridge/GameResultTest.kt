package bridge

import bridge.model.GameResult
import bridge.model.Move
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class GameResultTest {

    val size = 3
    lateinit var gameResult : GameResult

    @BeforeEach
    fun init() {
         gameResult = GameResult()
    }

    @Test
    fun `게임 실패를 확인하는 테스트`() {
        gameResult.setGameResult(Move.POSSIBLE)
        gameResult.setGameResult(Move.IMPOSSIBLE)
        val result = Result.FAIL

        assertThat(gameResult.checkGameSuccess(3)).isEqualTo(result)
    }

    @Test
    fun `게임 성공을 확인하는 테스트`() {
        gameResult.setGameResult(Move.POSSIBLE)
        gameResult.setGameResult(Move.IMPOSSIBLE)
        gameResult.setGameResult(Move.POSSIBLE)
        gameResult.setGameResult(Move.POSSIBLE)
        val result = Result.SUCCESS

        assertThat(gameResult.checkGameSuccess(3)).isEqualTo(result)
    }

}