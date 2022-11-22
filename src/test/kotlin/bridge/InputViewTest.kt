package bridge

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class InputViewTest {
    private val outputStreamCaptor = ByteArrayOutputStream()
    private val standardOut = System.out
    private val inputView = InputView()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
    }

    @ParameterizedTest
    @ValueSource(strings = ["rk", "(*&", "가나다"])
    fun `다리 길이 입력이 숫자가 아닌 입력을 받으면 오류를 발생시킨다`(input: String) {
        val gets = ByteArrayInputStream(input.toByteArray())
        System.setIn(gets)

        assertThrows<IllegalArgumentException> { inputView.readBridgeSize() }

    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "2", "21", "1000000000000000000000"])
    fun `다리 길이 입력이 허용된 입력 범위가 아니면 오류를 발생시킨다`(input: String ) {
        val gets = ByteArrayInputStream(input.toByteArray())
        System.setIn(gets)

        assertThrows<IllegalArgumentException> { inputView.readBridgeSize() }
    }

    @ParameterizedTest
    @ValueSource(strings = ["2", "사", "t", "dd", "r", "q"])
    fun `이동할 칸의 입력이 허용된 문자가 아니면 오류를 발생시킨다`(input: String) {
        val gets = ByteArrayInputStream(input.toByteArray())
        System.setIn(gets)

        assertThrows<IllegalArgumentException> { inputView.readMoving() }
    }

    @ParameterizedTest
    @ValueSource(strings = ["u", "d"])
    fun `이동할 칸의 입력이 소문자를 허용하지 않는다`(input: String) {
        val gets = ByteArrayInputStream(input.toByteArray())
        System.setIn(gets)

        assertThrows<IllegalArgumentException> { inputView.readMoving() }
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "나", "t", "dd", "d", "u"])
    fun `게임의 재시작 입력이 허용된 문자가 아니면 오류를 발생시킨다`(input: String) {
        val gets = ByteArrayInputStream(input.toByteArray())
        System.setIn(gets)

        assertThrows<IllegalArgumentException> { inputView.readGameCommand() }
    }

    @ParameterizedTest
    @ValueSource(strings = ["q", "r"])
    fun `게임의 재시작 입력이 소문자를 허용하지 않는다`(input: String) {
        val gets = ByteArrayInputStream(input.toByteArray())
        System.setIn(gets)

        assertThrows<IllegalArgumentException> { inputView.readGameCommand() }
    }

}
