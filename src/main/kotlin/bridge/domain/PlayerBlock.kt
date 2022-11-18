package bridge.domain

class PlayerBlock(
    private val direction: Direction,
    private val isMovable: Boolean
) {
    fun getDirection() = direction
    fun getIsMovable() = isMovable
}