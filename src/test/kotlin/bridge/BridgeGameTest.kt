package bridge

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class BridgeGameTest {
    @Test
    fun `움직임 테스트`() {
        val testGame1 = BridgeGame(BridgeMaker(TestNumberGenerator(listOf(1,1,0))), 3)
        assertThat(testGame1.move("U")).isEqualTo(false)
        assertThat(testGame1.move("U")).isEqualTo(false)
        assertThat(testGame1.move("D")).isEqualTo(true)

        val testGame2 = BridgeGame(BridgeMaker(TestNumberGenerator(listOf(1,1,0))), 3)
        assertThat(testGame2.move("U")).isEqualTo(false)
        assertThat(testGame2.move("D")).isEqualTo(true)
    }

    @Test
    fun `성공 여부 테스트`() {
        val testGame1 = BridgeGame(BridgeMaker(TestNumberGenerator(listOf(1,1,0))), 3)
        testGame1.move("U")
        testGame1.move("U")
        testGame1.move("D")
        assertThat(testGame1.isSuccess()).isEqualTo(true)

        val testGame2 = BridgeGame(BridgeMaker(TestNumberGenerator(listOf(1,1,0))), 3)
        testGame2.move("U")
        testGame2.move("U")
        testGame2.move("U")
        assertThat(testGame2.isSuccess()).isEqualTo(false)
    }

    class TestNumberGenerator(numbers: List<Int>) : BridgeNumberGenerator {
        private val numbers: MutableList<Int> = numbers.toMutableList()

        override fun generate(): Int {
            return numbers.removeAt(0)
        }
    }
}