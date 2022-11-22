package bridge

import org.assertj.core.api.Assertions
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test

class OutputBridgeMapTest : NsTest(){
    @Test
    fun `Up 정답 다리 출력 테스트`() {
        assertSimpleTest {
            OutputView(listOf("U","D","D")).printMapTrue(2, "U")
            Assertions.assertThat(output()).contains("[ O |   |   ]")
        }
    }
    @Test
    fun `Down 정답 다리 출력 테스트`() {
        assertSimpleTest {
            OutputView(listOf("U","D","D")).printMapTrue(2, "D")
            Assertions.assertThat(output()).contains("[   | O | O ]")
        }
    }
    @Test
    fun `정답 다리 출력 테스트`() {
        assertSimpleTest {
            OutputView(listOf("U","D","D")).printMap(2, true)
            Assertions.assertThat(output()).contains("[ O |   |   ]\n[   | O | O ]")
        }
    }
    @Test
    fun `Up 오답 다리 출력 테스트`() {
        assertSimpleTest {
            OutputView(listOf("U","D","D")).printMapFalse(2, "U")
            Assertions.assertThat(output()).contains("[ O |   | X ]")
        }
    }
    @Test
    fun `Down 오답 다리 출력 테스트`() {
        assertSimpleTest {
            OutputView(listOf("U","D","D")).printMapFalse(2, "D")
            Assertions.assertThat(output()).contains("[   | O |   ]")
        }
    }
    @Test
    fun `오답 다리 출력 테스트`() {
        assertSimpleTest {
            OutputView(listOf("U","D","D")).printMap(2, false)
            Assertions.assertThat(output()).contains("[ O |   | X ]\n[   | O |   ]")
        }
    }

    override fun runMain() {
        main()
    }
}