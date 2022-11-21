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

    @Test
    fun `칸 이동할 때 입력과 정답 판단 테스트`() {
        assertTrue(BridgeGame().move("U", "U"))
    }

    @Test
    fun `재시도 혹은 종료 테스트`() {
        assertFalse(BridgeGame().retry("Q"))
    }

    // 다리 만들기 테스트

    // 정답 입력 처리 테스트 2개(맞은 경우, 틀린 경우)

}