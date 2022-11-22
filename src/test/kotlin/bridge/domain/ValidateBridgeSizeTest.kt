package bridge.domain

import bridge.main
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ValidateBridgeSizeTest: NsTest() {

    @ParameterizedTest
    @ValueSource(strings = ["f", "가", "21", "-1", " ", "#"])
    fun `다리 크기가 3 이상 20 이하의 숫자가 아니면 예외를 던진다`(exceptionValue: String) {
        assertSimpleTest {
            runException(exceptionValue)
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        const val ERROR_MESSAGE = "[ERROR]"
    }


}