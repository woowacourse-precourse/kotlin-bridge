package bridge

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource


class InputViewTest: NsTest() {
    @Test
    fun `다리 길이 입력 테스트1`() {
        assertSimpleTest {
            run("1")
            assertThat(output()).contains("")
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["a", "35", "1", "-3"])
    fun `다리 길이 입력 예외 테스트`(input: String) {
        assertSimpleTest {
            runException(input)
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}