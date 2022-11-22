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

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }

    override fun runMain() {
        main()
    }

}