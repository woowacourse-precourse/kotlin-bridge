package bridge

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.DisplayName

class BrigeGameTest {
    @Test
    @DisplayName("다리 생성 테스트")
    fun `BridgeGame normal 3`() {
        assertSimpleTest {
            val numberGenerator: BridgeNumberGenerator = TestNumberGenerator(listOf(1, 0, 0))
            if (BridgeGame(BridgeMaker(numberGenerator),3).bridge == (listOf("U", "D", "D")))
                println("성공")
            else
                println("실패")
        }
    }

    class TestNumberGenerator(numbers: List<Int>) : BridgeNumberGenerator {
        private val numbers: MutableList<Int> = numbers.toMutableList()

        override fun generate(): Int {
            return numbers.removeAt(0)
        }
    }
}