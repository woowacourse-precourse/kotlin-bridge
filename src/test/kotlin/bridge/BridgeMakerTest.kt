package bridge

import camp.nextstep.edu.missionutils.test.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BridgeMakerTest {
    val bridgemaker = BridgeMaker(BridgeRandomNumberGenerator())
    @Test
    fun makeBridgeTest(){
        Assertions.assertRandomNumberInRangeTest({
            assertThat(bridgemaker.makeBridge(4)).isEqualTo(listOf("D","U","D","U"))
        },0,1,0,1)
    }
}