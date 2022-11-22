package bridge.domain.error

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ErrorCheckTest {

    @Test
    fun `입력받은 값이 정수가 아닌 경우 오류 발생`() {
        assertThrows<IllegalArgumentException> {
            ErrorCheck.checkIsInteger("a")
        }
    }

    @ValueSource(ints = [0, 21])
    @ParameterizedTest
    fun `입력받은 값이 범위를 벗어나는 경우 오류 발생`(input: Int) {
        assertThrows<IllegalArgumentException> {
            ErrorCheck.checkInRange(input)
        }
    }

    @Test
    fun `잘못된 이동 칸을 입력한 경우 오류 발생`() {
        assertThrows<IllegalArgumentException> {
            ErrorCheck.checkValidMovement("u")
        }
    }

    @Test
    fun `잘못된 재시작 옵션을 입력한 경우 오류 발생`() {
        assertThrows<IllegalArgumentException> {
            ErrorCheck.checkValidCommand("r")
        }
    }
}