package bridge.model

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator

class Bridge(directionNames: List<String>) {
    private val availableDirections: List<Direction>

    init {
        require(directionNames.size in MIN_SIZE..MAX_SIZE) { ERROR_BRIDGE_SIZE }
        availableDirections = directionNames.map { Direction.getByDisplayName(it) }
    }

    fun canCross(direction: Direction, position: Int): Boolean {
        return availableDirections[position] == direction
    }

    fun isBridgeEnd(position: Int): Boolean {
        return position == availableDirections.lastIndex
    }

    companion object {
        const val MIN_SIZE = 3
        const val MAX_SIZE = 20
        private const val ERROR_BRIDGE_SIZE = "다리 길이는 $MIN_SIZE 부터 $MAX_SIZE 사이의 숫자여야 합니다."

        fun generateRandomBridge(size: Int): Bridge {
            val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
            val directionNames = bridgeMaker.makeBridge(size)
            return Bridge(directionNames)
        }
    }
}
