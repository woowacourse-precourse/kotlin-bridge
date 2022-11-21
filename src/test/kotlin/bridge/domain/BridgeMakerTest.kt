package bridge.domain

import bridge.ApplicationTest
import bridge.BridgeNumberGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BridgeMakerTest(){
    @Test fun`makeBridgeTest`(){
        val numberGenerator: BridgeNumberGenerator = ApplicationTest.TestNumberGenerator(listOf(0, 0, 1))
        val bridgeMaker = BridgeMaker(numberGenerator)
        val bridge: List<String> = bridgeMaker.makeBridge(3)
        assertThat(bridge).containsExactly("D", "D", "U")
    }
}