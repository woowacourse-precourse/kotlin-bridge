package bridge.domain

class PlayerBlock(
    private val direction: Direction,
    private val isMovable: Boolean
) {
    fun getDirection() = direction
    fun getIsMovable() = isMovable

    override fun toString() = if (isMovable) SUCCESS_BLOCK else FAIL_BLOCK

    companion object {
        const val SUCCESS_BLOCK = "O"
        const val FAIL_BLOCK = "X"
    }
}