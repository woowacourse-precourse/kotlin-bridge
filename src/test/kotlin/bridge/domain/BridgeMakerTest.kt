package bridge.domain

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BridgeMakerTest {
    private val bridgeRandomNumberGenerator = BridgeRandomNumberGenerator()
    private val bridgeMaker = BridgeMaker(bridgeRandomNumberGenerator)
    @Test
    fun `다리 생성 테스트 - 경계값 3`() {
        assertThat(bridgeMaker.makeBridge(BOUNDARY_VALUE_LOW)
            .also { println(it.toString()) }
        ).hasSize(BOUNDARY_VALUE_LOW)
    }

    @Test
    fun `다리 생성 테스트 - 중간값 12`() {
        assertThat(bridgeMaker.makeBridge(MEDIAN)
            .also { println(it.toString()) }
        ).hasSize(MEDIAN)
    }

    @Test
    fun `다리 생성 테스트 - 경계값 20`() {
        assertThat(bridgeMaker.makeBridge(BOUNDARY_VALUE_HIGH)
            .also { println(it.toString()) }
        ).hasSize(BOUNDARY_VALUE_HIGH)
    }

    companion object {
        private const val BOUNDARY_VALUE_LOW = 3
        private const val MEDIAN = 12
        private const val BOUNDARY_VALUE_HIGH = 20
    }
}