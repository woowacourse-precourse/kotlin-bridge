package bridge

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class BridgeGameTest {
    @Test
    fun `다리의 끝까지 이동한 경우 게임이 종료된다`() {
        val testGame = BridgeGame(BridgeMaker(TestNumberGenerator(listOf(1,1,0))), 3)
        testGame.move("U")
        assertThat(testGame.isGameEnd()).isEqualTo(false)
        testGame.move("U")
        assertThat(testGame.isGameEnd()).isEqualTo(false)
        testGame.move("D")
        assertThat(testGame.isGameEnd()).isEqualTo(true)
    }

    @Test
    fun `다리의 이동 중에 다리와 다른 값으로 이동한 경우 게임이 종료된다`() {
        val testGame = BridgeGame(BridgeMaker(TestNumberGenerator(listOf(1,1,0))), 3)
        testGame.move("U")
        assertThat(testGame.isGameEnd()).isEqualTo(false)
        testGame.move("D")
        assertThat(testGame.isGameEnd()).isEqualTo(true)
    }

    @Test
    fun `사용자 입력 값과 다리의 값이 완전히 같은 경우 게임을 성공한다`() {
        val testGame = BridgeGame(BridgeMaker(TestNumberGenerator(listOf(1,1,0))), 3)
        testGame.move("U")
        testGame.move("U")
        testGame.move("D")
        assertThat(testGame.isSuccess()).isEqualTo(true)
    }

    @Test
    fun `사용자 입력 값과 다리의 값이 다른 경우 게임에 실패한다`() {
        val testGame = BridgeGame(BridgeMaker(TestNumberGenerator(listOf(1,1,0))), 3)
        testGame.move("U")
        testGame.move("U")
        testGame.move("U")
        assertThat(testGame.isSuccess()).isEqualTo(false)
    }

    class TestNumberGenerator(numbers: List<Int>) : BridgeNumberGenerator {
        private val numbers: MutableList<Int> = numbers.toMutableList()

        override fun generate(): Int {
            return numbers.removeAt(0)
        }
    }
}