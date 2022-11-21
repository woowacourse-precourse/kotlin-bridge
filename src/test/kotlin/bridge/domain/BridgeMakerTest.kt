package bridge.domain

import bridge.BridgeRandomNumberGenerator
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BridgeMakerTest {
    @ValueSource(ints = [2, 21])
    @ParameterizedTest
    fun `makeBridge 메서드에 정해진 범위를 벗어난 크기를 인자로 주면 예외 발생`(input: Int) {
        val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
        assertThrows<IllegalArgumentException> {
            bridgeMaker.makeBridge(input)
        }
    }
}