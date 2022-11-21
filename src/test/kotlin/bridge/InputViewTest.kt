package bridge

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InputViewTest : NsTest() {
    @Test
    fun `21 입력 예외 테스트`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest {
            runException(UPPER_EXCEPTION)
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `2 입력 예외 테스트`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest {
            runException(LOWER_EXCEPTION)
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `공백 입력 예외 테스트`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest {
            runException(SPACE_EXCEPTION)
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
        private const val UPPER_EXCEPTION = "21"
        private const val LOWER_EXCEPTION = "2"
        private const val SPACE_EXCEPTION = " "
    }
}