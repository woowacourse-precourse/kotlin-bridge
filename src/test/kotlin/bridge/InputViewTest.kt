package bridge

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.lang.String

class InputViewTest : NsTest() {
    @Test
    fun `길이 입력_사이즈 공백 예외 테스트`() {
        assertSimpleTest {
            val buf = String.join("\n", "\n5").toByteArray()
            System.setIn(ByteArrayInputStream(buf))
            val inputView = InputView()
            inputView.readBridgeSize()
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `길이 입력_숫자 외 값 예외 테스트`() {
        assertSimpleTest {
            val buf = String.join("\n", "a\n5").toByteArray()
            System.setIn(ByteArrayInputStream(buf))
            val inputView = InputView()
            inputView.readBridgeSize()
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `길이 입력_사이즈 범위 밖 숫자 예외 테스트`() {
        assertSimpleTest {
            val buf = String.join("\n", "22\n5").toByteArray()
            System.setIn(ByteArrayInputStream(buf))
            val inputView = InputView()
            inputView.readBridgeSize()
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `길이 입력_정상 작동`(){
        assertSimpleTest {
            System.setIn("5".byteInputStream())
            val inputView = InputView()
            inputView.readBridgeSize()
            assertThat(output()).doesNotContain(ERROR_MESSAGE)
        }
    }

    @Test
    fun `건너기 입력_공백 입력 예외`(){
        assertSimpleTest {
            val buf = String.join("\n", "\nU").toByteArray()
            System.setIn(ByteArrayInputStream(buf))
            val inputView = InputView()
            inputView.readMoving()
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `건너기 입력_비정상 입력 예외`(){
        assertSimpleTest {
            val buf = String.join("\n", "a\nU").toByteArray()
            System.setIn(ByteArrayInputStream(buf))
            val inputView = InputView()
            inputView.readMoving()
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `건너기 입력_정상 작동`(){
        assertSimpleTest {
            System.setIn("D".byteInputStream())
            val inputView = InputView()
            inputView.readMoving()
            assertThat(output()).doesNotContain(ERROR_MESSAGE)
        }
    }

    @Test
    fun `재시작 입력_공백 입력 예외`(){
        assertSimpleTest {
            val buf = String.join("\n", "\nR").toByteArray()
            System.setIn(ByteArrayInputStream(buf))
            val inputView = InputView()
            inputView.readGameCommand()
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `재시작 입력_비정상 입력 예외`(){
        assertSimpleTest {
            val buf = String.join("\n", "a\nR").toByteArray()
            System.setIn(ByteArrayInputStream(buf))
            val inputView = InputView()
            inputView.readGameCommand()
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `재시작 입력_정상 작동`(){
        assertSimpleTest {
            System.setIn("Q".byteInputStream())
            val inputView = InputView()
            inputView.readGameCommand()
            assertThat(output()).doesNotContain(ERROR_MESSAGE)
        }
    }
    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}