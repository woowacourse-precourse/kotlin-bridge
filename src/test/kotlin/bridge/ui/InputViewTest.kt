package bridge.ui

import bridge.main
import camp.nextstep.edu.missionutils.test.Assertions
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputViewTest : NsTest() {
    @Nested
    inner class BridgeLengthTest {
        @Test
        fun `다리 길이 입력문 - 문자열 입력테스트`() {
            Assertions.assertSimpleTest {
                runException("a", "ㅈㅇㄹㅈㅇ")
                assertThat(output()).contains(ERROR_MESSAGE)
            }
        }

        @Test
        fun `다리 길이 입력문 - 범위 외 값 입력테스트`() {
            Assertions.assertSimpleTest {
                runException("2", "55")
                assertThat(output()).contains(ERROR_MESSAGE)
            }
        }

        @Test
        fun `다리 길이 입력문 - 널값 입력테스트`() {
            Assertions.assertSimpleTest {
                runException("", "  ")
                assertThat(output()).contains(ERROR_MESSAGE)
            }
        }
    }

    @Nested
    inner class DirectionTest {
        @Test
        fun `방향 입력문 - 널값 입력테스트`() {
            Assertions.assertSimpleTest {
                assertThrows<IllegalArgumentException> { InputChecker().checkDirection("") }
            }
        }
        @Test
        fun `방향 입력문 - "U", "D"가 아닐 경우`() {
            Assertions.assertSimpleTest {
                assertThrows<IllegalArgumentException> { InputChecker().checkDirection("3") }
            }
        }

        @Test
        fun `방향 입력문 - "U", "D"가 아닐 경우2`() {
            Assertions.assertSimpleTest {
                assertThrows<IllegalArgumentException> { InputChecker().checkDirection("a") }
            }
        }
    }

    @Nested
    inner class CommandTest {
        @Test
        fun `커맨드 입력문 - 널값 입력테스트`() {
            Assertions.assertSimpleTest {
                assertThrows<IllegalArgumentException> { InputChecker().checkUserCommand("") }
            }
        }
        @Test
        fun `커맨드 입력문 - "R", "Q"가 아닐 경우`() {
            Assertions.assertSimpleTest {
                assertThrows<IllegalArgumentException> { InputChecker().checkUserCommand("3") }
            }
        }

        @Test
        fun `커맨드 입력문 - "R", "Q"가 아닐 경우2`() {
            Assertions.assertSimpleTest {
                assertThrows<IllegalArgumentException> { InputChecker().checkUserCommand("a") }
            }
        }
    }


    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }

}