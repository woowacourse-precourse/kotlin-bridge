package bridge

import bridge.constant.*
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat


class InputTest :NsTest() {

    @Test
    fun `다리 생성 길이 입력 예외 test`(){
        assertSimpleTest {
            runException("25")
            assertThat(output()).contains(ERROR_INPUT_BRIDGE_SIZE)
        }
    }
    @Test
    fun `플레이어 이동 입력 예외 test`(){
        assertSimpleTest {
            runException("3","Y")
            assertThat(output()).contains(ERROR_INPUT_PLAYER_MOVE)
        }
    }
    @Test
    fun `게임 재 시작, 종료 입력 예외 test`(){
        assertRandomNumberInRangeTest({
            runException("3", "U", "D", "D", "P")
            assertThat(output()).contains(ERROR_INPUT_COMMAND)
        }, 1, 0, 1)
    }

    override fun runMain() {
        main()
    }


}