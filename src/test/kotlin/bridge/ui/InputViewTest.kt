package bridge.ui

import bridge.error.ErrorMessage.ERROR_NOT_NUMBERS
import bridge.error.ErrorMessage.ERROR_NUM_NOT_IN_RANGE
import bridge.main
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputViewTest : NsTest() {
    @ValueSource(strings = ["-1","0","2","21","200"])
    @ParameterizedTest
    fun `숫자 범위 입력 예외 테스트`(input:String) {
        camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest {
            runException(input)
            assertThat(output()).contains(ERROR_NUM_NOT_IN_RANGE)
        }
    }

    @ValueSource(strings = [" ","a","b1","$"])
    @ParameterizedTest
    fun `문자나 공백 입력 예외 테스트`(input:String) {
        camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest {
            runException(input)
            assertThat(output()).contains(ERROR_NOT_NUMBERS)
        }
    }

    override fun runMain() {
        main()
    }
}