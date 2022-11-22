package bridge

import camp.nextstep.edu.missionutils.test.Assertions
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat

import org.junit.jupiter.api.Test

class InputViewTest : NsTest() {
    @Test
    fun `입력문 - 문자열 입력테스트`() {
        Assertions.assertSimpleTest {
            runException("a","ㅈㅇㄹㅈㅇ")
            assertThat(output()).contains(InputViewTest.ERROR_MESSAGE)
        }
    }

    @Test
    fun `입력문 - 범위 외 값 입력테스트`() {
        Assertions.assertSimpleTest {
            runException("2","55")
            assertThat(output()).contains(InputViewTest.ERROR_MESSAGE)
        }
    }

    @Test
    fun `입력문 - 널값 입력테스트`() {
        Assertions.assertSimpleTest {
            runException("","  ")
            assertThat(output()).contains(InputViewTest.ERROR_MESSAGE)
        }
    }


    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }

}