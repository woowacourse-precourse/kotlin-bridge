package bridge.model

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator

class Bridge(private val directionNames: List<String>) {

    // TODO: Direction 부분 넘기기

    init {
        require(directionNames.size in MIN_LENGTH..MAX_LENGTH)
        require(directionNames.all { it in Direction.names() })
    }

    operator fun get(position: Int): String {
        return directionNames[position]
    }

    fun available(moving: String, position: Int): Boolean {
        require(moving in Direction.names())
        return get(position) == moving
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