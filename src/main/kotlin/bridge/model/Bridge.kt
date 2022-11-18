package bridge.model

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator

class Bridge(directionNames: List<String>) {
    private val directions: List<Direction>

    init {
        require(directionNames.size in MIN_LENGTH..MAX_LENGTH) { ERROR_BRIDGE_LENGTH }
        directions = directionNames.map { Direction.getByDisplayName(it) }
    }

    fun canCross(direction: Direction, position: Int): Boolean {
        return directions[position] == direction
    }

    fun isBridgeEnd(position: Int): Boolean {
        return position == directions.lastIndex
    }

    companion object {
        const val MIN_LENGTH = 3
        const val MAX_LENGTH = 20
        private const val ERROR_BRIDGE_LENGTH = "다리길이는 $MIN_LENGTH 부터 $MAX_LENGTH 까지이어야 합니다."

        fun generateRandomBridge(size: Int): Bridge {
            val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
            val directionNames = bridgeMaker.makeBridge(size)
            return Bridge(directionNames)
        }
    }
}
