package bridge

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class BridgeTest : NsTest() {

    /** 다리 길이 입력 관련 테스트 **/

    @Test
    fun `다리 길이 입력 값에 문자열이 포함될 경우 예외가 발생한다`() {
        assertSimpleTest {
            Regex("a").checkBridgeLengthRegexes()
            Assertions.assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `다리 길이 입력 값이 공백일 경우 예외가 발생한다`() {
        assertSimpleTest {
            Regex("").checkBridgeLengthRegexes()
            Assertions.assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `다리 길이 입력 값이 범위를 벗어날 경우 예외가 발생한다 - 넘을 경우`() {
        assertSimpleTest {
            Regex("36").checkBridgeLengthRegexes()
            Assertions.assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `다리 길이 입력 값이 범위를 벗어날 경우 예외가 발생한다 - 모자랄 경우`() {
        assertSimpleTest {
            Regex("2").checkBridgeLengthRegexes()
            Assertions.assertThat(output()).contains(ERROR_MESSAGE)
        }
    }


    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}