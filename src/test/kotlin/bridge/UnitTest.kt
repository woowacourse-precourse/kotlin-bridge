package bridge

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import domain.BridgeMaker
import domain.BridgeNumberGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UnitTest: NsTest() {

    private val numberGenerator: BridgeNumberGenerator = ApplicationTest.TestNumberGenerator(listOf(1, 0, 0))
    private val bridgeMaker = BridgeMaker(numberGenerator)
    private val bridge: List<String> = bridgeMaker.makeBridge(3)

    @Test
    fun `다리 생성 테스트`() {
        assertThat(bridge).containsExactly("U", "D", "D")
    }

    @Test
    fun `공백을 입력한 경우`() {
        assertSimpleTest {
            runException(" ")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }
    @Test
    fun `다리길이가 20을 초과한 경우`() {
        assertSimpleTest {
            runException("25")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `다리길이가 3미만인 경우`() {
        assertSimpleTest {
            runException("1")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }

    override fun runMain() {
        main()
    }

}