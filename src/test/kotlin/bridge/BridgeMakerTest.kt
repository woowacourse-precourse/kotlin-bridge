package bridge

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class BridgeMakerTest {
    @ParameterizedTest
    @MethodSource("providerBridgeNumbers")
    fun `다리를 길이만큼 생성한다`(bridge: List<String>, size: Int) {
        assertRandomNumberInRangeTest({
            val bridgeNumberGenerator = BridgeRandomNumberGenerator()
            val bridgeMaker = BridgeMaker(bridgeNumberGenerator).makeBridge(size)
            assertThat(bridgeMaker).isEqualTo(bridge)
        }, 1, 0, 1, 0, 1)
    }

    companion object {
        @JvmStatic
        private fun providerBridgeNumbers() = listOf(
            Arguments.of(listOf("U", "D", "U"), 3), Arguments.of(listOf("U", "D", "U", "D", "U"), 5)
        )
    }
}