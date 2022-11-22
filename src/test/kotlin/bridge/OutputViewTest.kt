package bridge

import bridge.View.OutputView
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream


class OutputViewTest {

    private val upSelectedBridge = listOf("O"," ")
    private val downSelectedBridge = listOf(" ","X")

    @Test
    fun `다리 이동 상태 출력 테스트`() {
        val outContent = ByteArrayOutputStream()
        System.setOut(PrintStream(outContent))
        OutputView().printMap(upSelectedBridge, downSelectedBridge)
        assertEquals("[ O |   ]\n[   | X ]\n\n", outContent.toString())
    }

}