package bridge

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BridgeGameTest : NsTest() {
    override fun runMain() {
        main()
    }

    @Test
    fun `다리길이 정상적인 입력값을 받았을 경우`() {
        assertSimpleTest {
            run("3")
            assertThat(output())
        }
    }

    @Test
    fun `다리 길이 입력값에 문자가 들어갈 경우 예외 처리`() {
        // 문자가 들어갔을 경우
        assertSimpleTest {
            runException("10j")
            assertThat(output()).contains("[ERROR]")
        }

        // 3-20 범위를 벗어났을 경우
        assertSimpleTest {
            runException("33")
            assertThat(output()).contains("[ERROR]")
        }
    }

    @Test
    fun `이동할 칸 입력 값에 U 또는 D가 들어가지 않았을 경우 예외처리`() {
        // 3-20 범위를 벗어났을 경우
        assertSimpleTest {
            runException("3", "위", "u")
            assertThat(output()).contains("[ERROR]")
        }
    }

    @Test
    fun `이동한 결과에 따른 맵을 출력하는지 확인`() {
        assertRandomNumberInRangeTest ({
            run("5", "U", "U", "D", "U", "D")
            assertThat(output()).contains(
                "[ O | O |   | O |   ]",
                "[   |   | O |   | O ]",
            )
        }, 1, 1, 0, 1, 0)

    }
}