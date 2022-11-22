package bridge.domain

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class BridgeStateTest : NsTest() {
    private val bridgeState = BridgeState()

    @Test
    fun `다리 건너기 성공 테스트`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest {
            run("U", "D", "D", "U")
            Assertions.assertThat(output()).contains(
                    "[ O ]",
                    "[   ]",
                    "[ O |   ]",
                    "[   | O ]",
                    "[ O |   |   ]",
                    "[   | O | O ]",
                    "[ O |   |   | O ]",
                    "[   | O | O |   ]"
            )
        }
    }

    @Test
    fun `다리 건너기 실패 테스트`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest {
            run("U", "D", "U")
            Assertions.assertThat(output()).contains(
                    "[ O ]",
                    "[   ]",
                    "[ O |   ]",
                    "[   | O ]",
                    "[ O |   | X ]",
                    "[   | O |   ]"
            )
        }
    }

    override fun runMain() {
        bridgeState.compare(testBridge)
    }

    companion object {
        val testBridge = Bridge(listOf("U", "D", "D", "U"))
    }
}