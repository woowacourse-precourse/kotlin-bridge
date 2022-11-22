package bridge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OutputViewTest {

    @Test
    fun `joinToString이 잘 작동하는지 확인`() {
        val markUp = listOf("O", " ", "O", "O")
        val result = markUp.joinToString(" | ", "[ ", " ]")
        assertThat(result).isEqualTo("[ O |   | O | O ]")
    }
}