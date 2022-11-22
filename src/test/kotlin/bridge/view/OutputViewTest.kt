package bridge.view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.OutputStream
import java.io.PrintStream

internal class OutputViewTest {

    private var standardOut: PrintStream? = null
    private var captor: OutputStream? = null

    @BeforeEach
    fun init() {
        standardOut = System.out
        captor = ByteArrayOutputStream()
        System.setOut(PrintStream(captor))
    }

    private fun output(): String {
        return captor.toString().trim { it <= ' ' }
    }

    @Test
    fun `printMap 정상작동 테스트 bridgeCurrentState 가 true 일때`() {
        OutputView().printMap(true, 3, listOf("U", "D", "U", "U", "D"))
        assertThat(output()).contains("[ O |   | O ]", "[   | O |   ]")
    }

    @Test
    fun `printMap 정상작동 테스트 bridgeCurrentState 가 false 일때`() {
        OutputView().printMap(false, 3, listOf("U", "D", "U", "U", "D"))
        assertThat(output()).contains("[ O |   |   ]", "[   | O | X ]")
    }
}
