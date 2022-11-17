package bridge.model

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator

class Bridge(private val directionNames: List<String>) {

    init {
        require(directionNames.size in MIN_LENGTH..MAX_LENGTH)
        require(directionNames.all { it in Direction.names() })
    }

    companion object {
        const val MIN_LENGTH = 3
        const val MAX_LENGTH = 20

        fun generate(size: Int): Bridge {
            val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
            val directionNames = bridgeMaker.makeBridge(size)
            return Bridge(directionNames)
        }
    }
}