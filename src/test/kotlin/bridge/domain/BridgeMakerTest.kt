package bridge.domain

import bridge.ApplicationTest
import bridge.ApplicationTest.*
import bridge.BridgeNumberGenerator
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

    @Test
    fun `makeBridge 메서드로 다리 생성 시 지정한 방향을 나타내는 숫자 이외의 숫자로 생성하면 예외 발생`() {
        val numberGenerator: BridgeNumberGenerator = TestNumberGenerator(listOf(-1, 0, 1))
        val bridgeMaker = BridgeMaker(numberGenerator)
        assertThrows<IllegalArgumentException> {
            val bridge: List<String> = bridgeMaker.makeBridge(3)
        }
    }
}