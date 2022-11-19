package bridge

import camp.nextstep.edu.missionutils.test.NsTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class InputBridgeMoveTest : NsTest(){

    @Test
    fun `이동할 칸 입력 테스트`() {
        assertSimpleTest {
            run("U")
            Assertions.assertThat(output()).isEqualTo("이동할 칸을 선택해주세요. (위: U, 아래: D)", "U")
        }
    }
    @Test
    fun `이동할 칸 입력 테스트 예외 1`() {
        assertSimpleTest{
            runException("a")
            Assertions.assertThat(output()).contains(ERROR_MESSAGE)
        }
    }
    override fun runMain() {
        InputView().readMoving()
    }
    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}