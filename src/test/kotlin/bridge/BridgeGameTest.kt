package bridge

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.lang.String

class BridgeGameTest : NsTest(){

    @Test
    fun `다리 건너기 성공 테스트`(){
        val bridge = listOf("U","U","D")
        tryCount = 0
        System.setIn("U".byteInputStream())
        assertSimpleTest{
            BridgeGame().move(bridge)
            assertThat(output()).contains(
                "[ O ]",
                "[   ]"
            )
        }
    }

    @Test
    fun `다리 건너기 실패 테스트`(){
        val bridge = listOf("U","U","D")
        tryCount = 0
        val buf = String.join("\n", "D\nR").toByteArray()
        System.setIn(ByteArrayInputStream(buf))
        assertSimpleTest{
            BridgeGame().move(bridge)
            assertThat(output()).contains(
                "[   ]",
                "[ X ]"
            )
        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}