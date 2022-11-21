package bridge.data

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GameResultTest{
    val gameResult = GameResult()

    @Test
    fun `matchTest`() {
        val result = "성공"
        gameResult.succeed()
        assertThat(result).isEqualTo(gameResult.result)
    }
}
