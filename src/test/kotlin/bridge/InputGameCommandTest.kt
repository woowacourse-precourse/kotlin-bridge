package bridge

import org.assertj.core.api.Assertions.assertThat
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test

class InputGameCommandTest : NsTest(){

    @Test
    fun `게임 재시도 여부 입력 테스트`() {
        assertSimpleTest{
            run("R")
            assertThat(output()).isEqualTo("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)","R")
        }
    }

    @Test
    fun `게임 재시도 여부 입력 테스트 예외 1`() {
        assertSimpleTest{
            runException("a")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    override fun runMain() {
        InputView().readGameCommand()
    }
    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}