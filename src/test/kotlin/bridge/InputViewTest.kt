package bridge

import org.assertj.core.api.Assertions.assertThat
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test

class InputViewTest : NsTest(){

    @Test
    fun `다리 길이 입력 테스트`() {
        assertSimpleTest{
            run("12")
            assertThat(output()).isEqualTo("다리의 길이를 입력해주세요.",12)
        }
    }

    @Test
    fun `다리 길이 입력 테스트 예외 1`() {
        assertSimpleTest{
            runException("a")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `다리 길이 입력 테스트 예외 2`() {
        assertSimpleTest{
            runException("23")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    override fun runMain() {
        InputView().readBridgeSize()
    }
    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}