package bridge.model

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator

class Bridge(directionNames: List<String>) {
    private val directions: List<Direction>

    init {
        require(directionNames.size in MIN_LENGTH..MAX_LENGTH)
        directions = directionNames.map { Direction.getByName(it) }
    }

    fun available(moving: String, position: Int): Boolean {
        val direction = Direction.getByName(moving)
        return directions[position] == direction
    }

    fun isBridgeEnd(position: Int): Boolean {
        return position == directions.lastIndex
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