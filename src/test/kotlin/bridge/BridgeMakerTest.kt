package bridge

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BridgeMakerTest {
    private val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())

    @Test
    fun `랜덤값 변환 테스트`() {
        assertRandomNumberInRangeTest({
            assertThat(bridgeMaker.makeBridge(4)).isEqualTo(listOf("U", "U", "D", "U"))
        }, 1, 1, 0, 1)
    }

    @Test
    fun `만든 다리 개수 테스트`() {
        assertThat(bridgeMaker.makeBridge(4)).hasSize(4)
    }
}
