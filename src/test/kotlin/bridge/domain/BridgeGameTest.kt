package bridge.domain

import bridge.constants.String.Companion.STRING_CORRECT
import bridge.constants.String.Companion.STRING_DOWN
import bridge.constants.String.Companion.STRING_QUIT
import bridge.constants.String.Companion.STRING_RETRY
import bridge.constants.String.Companion.STRING_UP
import bridge.constants.String.Companion.STRING_WRONG
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BridgeGameTest {
    private val bridgeGame = BridgeGame()

    @Test
    fun `move 함수 테스트 1`() {
        assertThat(bridgeGame.move(STRING_UP, STRING_UP)).isEqualTo(STRING_CORRECT)
    }

    @Test
    fun `move 함수 테스트 2`() {
        assertThat(bridgeGame.move(STRING_UP, STRING_DOWN)).isEqualTo(STRING_WRONG)
    }

    @Test
    fun `retry 함수 테스트 1`() {
        assertThat(bridgeGame.retry(STRING_RETRY)).isTrue
    }

    @Test
    fun `retry 함수 테스트 2`() {
        assertThat(bridgeGame.retry(STRING_QUIT)).isFalse
    }
}