package bridge.domain

import bridge.ApplicationTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class InputViewTest : NsTest() {
    private val inputView = InputView()

    @ParameterizedTest
    @CsvSource(DIGIT_EXCEPTION, RANGE_EXCEPTION)
    fun `다리 길이 입력 테스트`(bridgeSize: String) {
        assertSimpleTest {
            runException(bridgeSize)
            Assertions.assertThat(output()).contains(PREFIX)
        }
    }

    override fun runMain() {
        inputView.retryReadBridgeSize()
    }

    companion object {
        private const val PREFIX = "[ERROR]"

        private const val DIGIT_EXCEPTION = "a"
        private const val RANGE_EXCEPTION = "21"
    }
}