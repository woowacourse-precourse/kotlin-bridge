package bridge.view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CommandCheckerTest {
    @Test
    fun `명령어가 R 또는 Q가 아닌 다른 알파벳이면 예외 처리`() {
        val result = CommandChecker("a").checkAll()
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun `명령어가 기호이면 예외 처리`() {
        val result = CommandChecker("!").checkAll()
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun `명령어가 숫자이면 예외 처리`() {
        val result = CommandChecker("0").checkAll()
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun `명령어가 정상일 경우`() {
        val result = CommandChecker("R").checkAll()
        assertThat(result).isEqualTo(false)
    }
}