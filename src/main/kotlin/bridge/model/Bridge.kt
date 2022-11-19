package bridge.model

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator

/**
 * 길이에 대한 유효성 검증,
 * 특정 방향으로 건널 수 있는지 확인,
 * 다리의 마지막 위치인지 확인 해주는 역활을 한다.
 */
class Bridge(directionCommands: List<String>) {
    private val availableDirections: List<Direction>

    init {
        require(directionCommands.size in MIN_SIZE..MAX_SIZE) { ERROR_BRIDGE_SIZE }
        availableDirections = directionCommands.map { Direction.getByCommand(it) }
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
