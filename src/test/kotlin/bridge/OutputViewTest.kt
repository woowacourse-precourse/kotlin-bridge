package bridge

import bridge.UI.OutputView
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream


class OutputViewTest {

    @Test
    fun `다리 이동 상태 출력 테스트`() {
        val upSelectedBridge = listOf("O")
        val downSelectedBridge = listOf(" ")
        val outContent = ByteArrayOutputStream()
        System.setOut(PrintStream(outContent))
        OutputView().printMap(upSelectedBridge, downSelectedBridge)
        assertEquals("[ O ]\n[   ]\n\n", outContent.toString())
    }

}