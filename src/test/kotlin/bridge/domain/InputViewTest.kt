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


    @ParameterizedTest(name = "다리 길이 입력 테스트: {0}")
    @CsvSource(DIGIT_EXCEPTION, RANGE_EXCEPTION)
    fun `다리 길이 입력 테스트`(bridgeSize: String) {
        assertSimpleTest {
            runException(bridgeSize)
            Assertions.assertThat(output()).contains(PREFIX)
        }
    }

    @ParameterizedTest(name = "이동 입력 테스트: {0}")
    @CsvSource(MOVE_DIGIT_EXCEPTION, MOVE_LETTER_EXCEPTION)
    fun `이동 입력 테스트`(moving: String) {
        assertSimpleTest {
            runException(moving)
            Assertions.assertThat(output()).contains(PREFIX)
        }
    }

    @Test
    fun retryReadGameCommand() {
    }

    override fun runMain() {
        // 다리 길이 입력 테스트: inputView.retryReadBridgeSize()
        // 이동 입력 테스트:
        inputView.retryReadMoving()
    }

    companion object {
        private const val PREFIX = "[ERROR]"

        private const val DIGIT_EXCEPTION = "a"
        private const val RANGE_EXCEPTION = "21"

        private const val MOVE_DIGIT_EXCEPTION = "3"
        private const val MOVE_LETTER_EXCEPTION = "F"
    }
}