package bridge._assist

import bridge.domain.BridgeMaker
import bridge.domain.BridgeNumberGenerator

internal class TestNumberGenerator(numbers: List<Int>) : BridgeNumberGenerator {
    private val numbers: MutableList<Int> = numbers.toMutableList()

    override fun generate(): Int {
        return numbers.removeAt(0)
    }

    companion object {

        fun generateBridge(vararg elements: Int): List<String> {
            val numberGenerator: BridgeNumberGenerator = TestNumberGenerator(elements.toList())
            val bridgeMaker = BridgeMaker(numberGenerator)
            return bridgeMaker.makeBridge(elements.size)
        }
    }
}