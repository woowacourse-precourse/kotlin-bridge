package bridge.view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MovingCheckerTest {
    @Test
    fun `이동할 칸이 U 또는 D가 아닌 다른 알파벳이면 예외 처리`() {
        val result = MovingChecker("a").checkAll()
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun `이동할 칸이 기호이면 예외 처리`() {
        val result = MovingChecker("!").checkAll()
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun `이동할 칸이 숫자이면 예외 처리`() {
        val result = MovingChecker("0").checkAll()
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun `이동할 칸이 정상일 경우`() {
        val result = MovingChecker("U").checkAll()
        assertThat(result).isEqualTo(false)
    }
}