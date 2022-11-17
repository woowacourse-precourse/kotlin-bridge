package bridge

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.lang.String

class InputViewTest : NsTest() {
    @Test
    fun `사이즈 공백 예외 테스트`() {
        assertSimpleTest {
            val buf = String.join("\n", "\n5").toByteArray()
            System.setIn(ByteArrayInputStream(buf))
            val inputView = InputView()
            inputView.readBridgeSize()
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `숫자 외 값 예외 테스트`() {
        assertSimpleTest {
            val buf = String.join("\n", "a\n5").toByteArray()
            System.setIn(ByteArrayInputStream(buf))
            val inputView = InputView()
            inputView.readBridgeSize()
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `사이즈 범위 밖 숫자 예외 테스트`() {
        assertSimpleTest {
            val buf = String.join("\n", "22\n5").toByteArray()
            System.setIn(ByteArrayInputStream(buf))
            val inputView = InputView()
            inputView.readBridgeSize()
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}