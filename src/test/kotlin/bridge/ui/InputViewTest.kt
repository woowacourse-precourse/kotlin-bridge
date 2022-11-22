package bridge.ui

import bridge.error.ErrorMessage.ERROR_NOT_NUMBERS
import bridge.error.ErrorMessage.ERROR_NOT_RETRY_QUIT
import bridge.error.ErrorMessage.ERROR_NOT_UP_DOWN
import bridge.error.ErrorMessage.ERROR_NUM_NOT_IN_RANGE
import bridge.main
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputViewTest : NsTest() {
    @ValueSource(strings = ["-1", "0", "2", "21", "200"])
    @ParameterizedTest
    fun `숫자 범위 입력 예외 테스트`(input: String) {
        camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest {
            runException(input)
            assertThat(output()).contains(ERROR_NUM_NOT_IN_RANGE)
        }
    }

    @ValueSource(strings = [" ", "A", "b1", "$", "UU", "D U", "10.5"])
    @ParameterizedTest
    fun `문자나 공백 소수 입력 예외 테스트`(input: String) {
        camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest {
            runException(input)
            assertThat(output()).contains(ERROR_NOT_NUMBERS)
        }
    }

    @ValueSource(strings = [" ", "R", "10", "-1", "U1", "DD"])
    @ParameterizedTest
    fun `U나 D가 아닌 입력 예외 테스트`(input: String) {
        camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest {
            runException("3", input)
            assertThat(output()).contains(ERROR_NOT_UP_DOWN)
        }
    }

    @ValueSource(strings = [" ", "U", "RR", "Q1", "-1"])
    @ParameterizedTest
    fun `R이나 Q가 아닌 입력 예외 테스트`(input: String) {
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest({
            runException("3", "U", "D", "D", input)
            assertThat(output()).contains(ERROR_NOT_RETRY_QUIT)
            val upSideIndex = output().indexOf("[ O |   |   ]")
            val downSideIndex = output().indexOf("[   | O | X ]")
            Assertions.assertThat(upSideIndex).isLessThan(downSideIndex)
        }, 1, 0, 1)
    }

    override fun runMain() {
        main()
    }
}