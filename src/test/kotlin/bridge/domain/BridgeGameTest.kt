package bridge.domain

import bridge.enums.Status
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class BridgeGameTest {
    private val bridgeGame = BridgeGame()

    @Test
    fun `이동 함수 테스트 - 정답`() {
        assertThat(bridgeGame.move(MOVE_CORRECT[0], MOVE_CORRECT[1]).also { println(it) }).isEqualTo(Status.CORRECT)
    }

    @Test
    fun `이동 함수 테스트 - 오답`() {
        assertThat(bridgeGame.move(MOVE_WRONG[0], MOVE_WRONG[1]).also { println(it) }).isEqualTo(Status.WRONG)
    }

    @Test
    fun `재시작 함수 테스트 - 재시작`() {
        assertThat((bridgeGame.retry(RETRY_RESTART)).also { println(it) }).isEqualTo(true)
    }

    @Test
    fun `재시작 함수 테스트 - 종료`() {
        assertThat((bridgeGame.retry(RETRY_QUIT)).also { println(it) }).isEqualTo(false)
    }

    @Test
    fun `오답 or 끝 도달 여부 판단 함수 테스트 - 끝 도달`() {
        assertThat((bridgeGame.escape(ESCAPE_INDEX_END, ESCAPE_BRIDGE, ESCAPE_PROGRESS_END))
            .also { println(it) }
        ).isEqualTo(false)
    }

    @Test
    fun `오답 or 끝 도달 여부 판단 함수 테스트 - 오답`() {
        assertThat((bridgeGame.escape(ESCAPE_INDEX_ONGOING, ESCAPE_BRIDGE, ESCAPE_PROGRESS_WRONG))
            .also { println(it) }
        ).isEqualTo(false)
    }

    @Test
    fun `오답 or 끝 도달 여부 판단 함수 테스트 - 진행 중`() {
        assertThat((bridgeGame.escape(ESCAPE_INDEX_ONGOING, ESCAPE_BRIDGE, ESCAPE_PROGRESS_ONGOING))
            .also { println(it) }
        ).isEqualTo(true)
    }

    companion object {
        private val MOVE_CORRECT = listOf<String>("U", "U")
        private val MOVE_WRONG = listOf<String>("U", "D")

        private const val RETRY_RESTART = "R"
        private const val RETRY_QUIT = "Q"

        private const val ESCAPE_INDEX_END = 3
        private const val ESCAPE_INDEX_ONGOING = 2
        private val ESCAPE_BRIDGE = listOf<String>("U", "D", "U")
        private val ESCAPE_PROGRESS_END = mutableListOf<Status>(Status.CORRECT, Status.CORRECT, Status.CORRECT)
        private val ESCAPE_PROGRESS_WRONG = mutableListOf<Status>(Status.CORRECT, Status.WRONG)
        private val ESCAPE_PROGRESS_ONGOING = mutableListOf<Status>(Status.CORRECT, Status.CORRECT)
    }
}