package bridge
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class FunctionTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            ExceptionCheck.checkDirection("a")
        }
    }
}
