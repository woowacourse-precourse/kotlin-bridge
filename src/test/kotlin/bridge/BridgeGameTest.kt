package bridge

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class BridgeGameTest {
    @Test
    fun `게임 진행 중 이동할 수 없는 칸이면 종료한다`() {
        val game = BridgeGame(BridgeMaker(TestNumberGenerator(listOf(0, 1, 0))), 3)
        game.move("D")
        assertThat(game.isSuccess()).isEqualTo(true)
        game.move("D")
        assertThat(game.isSuccess()).isEqualTo(false)
    }

    @Test
    fun `플레이어가 모든 다리를 건너면 게임에 성공한다`() {
        val game = BridgeGame(BridgeMaker(TestNumberGenerator(listOf(0, 1, 0))), 3)
        game.move("D")
        game.move("U")
        game.move("D")
        assertThat(game.isSuccess()).isEqualTo(true)
    }

    @Test
    fun `게임을 재시작하면 플레이어가 움직인 기록을 지운다`() {
        val game = BridgeGame(BridgeMaker(TestNumberGenerator(listOf(0, 1, 0))), 3)
    }

    class TestNumberGenerator(numbers: List<Int>) : BridgeNumberGenerator {
        private val numbers: MutableList<Int> = numbers.toMutableList()

        override fun generate(): Int {
            return numbers.removeAt(0)
        }
    }
}