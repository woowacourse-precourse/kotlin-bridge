package bridge.domain

import bridge.ApplicationTest
import bridge.enums.GameMessages
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class InputViewTest : NsTest() {
    private val inputView = InputView()


    @ParameterizedTest(name = "다리 길이 입력 테스트: {0}")
    @CsvSource(LETTER_EXCEPTION, RANGE_EXCEPTION)
    fun `다리 길이 입력 테스트`(bridgeSize: String) {
        assertSimpleTest {
            runException(bridgeSize)
            Assertions.assertThat(output()).contains(
                GameMessages.INPUT_BRIDGE_SIZE.toString(),
                PREFIX,
                GameMessages.INPUT_BRIDGE_SIZE.toString()
            )
        }
    }

    @ParameterizedTest(name = "이동 입력 테스트: {0}")
    @CsvSource(DIGIT_EXCEPTION, LETTER_EXCEPTION)
    fun `이동 입력 테스트`(moving: String) {
        assertSimpleTest {
            runException(moving)
            Assertions.assertThat(output()).contains(
                GameMessages.INPUT_UP_DOWN.toString(),
                PREFIX,
                GameMessages.INPUT_UP_DOWN.toString()
            )
        }
    }

    @ParameterizedTest(name = "재시작 종료 입력 테스트: {0}")
    @CsvSource(DIGIT_EXCEPTION, LETTER_EXCEPTION)
    fun `재시작 종료 입력 테스트`(gameCommand: String) {
        assertSimpleTest {
            runException(gameCommand)
            Assertions.assertThat(output()).contains(
                GameMessages.INPUT_RESTART_QUIT.toString(),
                PREFIX,
                GameMessages.INPUT_RESTART_QUIT.toString()
            )
        }
    }

    override fun runMain() {
        // 다리 길이 입력 테스트:
        // inputView.retryReadBridgeSize()
        // 이동 입력 테스트:
        // inputView.retryReadMoving()
        // 재시작 종료 입력 테스트
        inputView.retryReadGameCommand()
    }

    companion object {
        private const val PREFIX = "[ERROR]"

        private const val LETTER_EXCEPTION = "a"
        private const val RANGE_EXCEPTION = "21"
        private const val DIGIT_EXCEPTION = "1"
    }
}