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
    fun `다리 길이 입력 값이 빈칸일 경우 예외가 발생한다`() {
        assertSimpleTest {
            Regex(" ").checkBridgeLengthRegexes()
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

    @Test
    fun `다리 길이 입력 값 성공`() {
        assertSimpleTest {
            Regex("3").checkBridgeLengthRegexes()
            Assertions.assertThat(output())
        }
    }

    /** 사용자가 입력하는 다리 이동 문자열 관련 테스트 **/
    @Test
    fun `유저가 이동할 칸을 소문자로 입력했을 경우 예외가 발생한다`() {
        assertSimpleTest {
            Regex("u").checkUserMovementRegexes()
            Assertions.assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `유저가 이동할 칸을 다른 문자로 입력했을 경우 예외가 발생한다`() {
        assertSimpleTest {
            Regex("R").checkUserMovementRegexes()
            Assertions.assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `유저가 이동할 칸을 공백으로 입력했을 경우 예외가 발생한다`() {
        assertSimpleTest {
            Regex("").checkUserMovementRegexes()
            Assertions.assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `유저가 이동할 칸을 빈칸으로 입력했을 경우 예외가 발생한다`() {
        assertSimpleTest {
            Regex(" ").checkUserMovementRegexes()
            Assertions.assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `유저가 이동할 칸을 잘 입력했을 경우`() {
        assertSimpleTest {
            Regex("D").checkUserMovementRegexes()
            Assertions.assertThat(output())
        }
    }

    /** 유저가 입력하는 재시도 문자열 관련 테스트 **/

    @Test
    fun `재시도 입력 값이 공백일 경우 예외가 발생한다`() {
        assertSimpleTest {
            Regex("").checkUserRetryRegexes()
            Assertions.assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `재시도 입력 값이 빈칸일 경우 예외가 발생한다`() {
        assertSimpleTest {
            Regex(" ").checkUserRetryRegexes()
            Assertions.assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `재시도 입력 값이 다른 문자일 경우 예외가 발생한다`() {
        assertSimpleTest {
            Regex("").checkUserRetryRegexes()
            Assertions.assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `재시도 입력 값이 올바를 경우 - 대문자`() {
        assertSimpleTest {
            Regex("R").checkUserRetryRegexes()
            Assertions.assertThat(output())
        }
    }

    @Test
    fun `재시도 입력 값이 올바를 경우 - 소문자`() {
        assertSimpleTest {
            Regex("r").checkUserRetryRegexes()
            Assertions.assertThat(output())
        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}