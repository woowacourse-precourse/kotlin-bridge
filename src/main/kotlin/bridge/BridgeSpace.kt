package bridge

import bridge.model.BridgeDirection

class BridgeSpace(
    private val direction: BridgeDirection,
    private val position: Int
) {

    fun getDirection() : BridgeDirection = direction

    fun matchBridgeSpace(user: BridgeSpace): Move {
        if (this.equals(user)) return Move.POSSIBLE
        return Move.IMPOSSIBLE
    }

    override fun equals(other: Any?): Boolean = when (other) {
        is BridgeSpace -> other.direction == this.direction && other.position == this.position
        else -> false
    }

}