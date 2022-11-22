package bridge

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class BridgeTest {
    class InputException {
        @Test
        fun `숫자가 아닌 값 입력했을 경우`() {
            assertThrows<IllegalArgumentException> {
                Validator().validateBridgeSize("a")
            }
        }

        @Test
        fun `주어진 범위 안에 있지 않은 경우`() {
            assertThrows<IllegalArgumentException> {
                Validator().validateBridgeSize("2")
            }
        }

        @Test
        fun `U나 D가 아닌 값을 입력했을 경우`() {
            assertThrows<IllegalArgumentException> {
                Validator().validateUpAndDown("Q")
            }
        }

        @Test
        fun `R이나 Q가 아닌 값을 입력했을 경우`() {
            assertThrows<IllegalArgumentException> {
                Validator().validateRetryAndQuit("U")
            }
        }
    }

    class MoveTest() {
        @Test
        fun `칸 이동할 때 입력과 정답이 맞았을 경우`() {
            assertTrue(BridgeGame().move("U", "U"))
        }

        @Test
        fun `칸 이동할 때 입력과 정답이 틀렸을 경우`() {
            assertFalse(BridgeGame().move("D", "U"))
        }
    }

    class RetryTest() {
        @Test
        fun `종료 테스트`() {
            assertFalse(BridgeGame().retry("Q"))
        }

        @Test
        fun `재시도 테스트`() {
            assertTrue(BridgeGame().retry("R"))
        }
    }

    @Test
    fun `다리 만들기 테스트`() {
        val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(5)
        assertTrue(bridge.size == 5)
    }

    @Test
    fun `입력값과 정답따라 다리 결정 테스트`() {
        val bridge = listOf("U", "D", "U")
        val userStep = listOf(true, false)
        val printValue = BridgeGame().determineMap(bridge, userStep)
        val answer = mutableListOf(listOf(" ", "O"), listOf(" ", "X"))
        assertTrue(printValue == answer)
    }
}