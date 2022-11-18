package bridge.model

enum class Direction(private val value: Int, private val displayName: String) {
    UP(1, "U"), DOWN(0, "D");

    override fun toString() = this.displayName

    companion object {
        private const val ERROR_NO_MATCHED_DIRECTION = "%s와 일치하는 방향이 없습니다."
        fun getByValue(value: Int): Direction {
            return Direction.values().firstOrNull { it.value == value } ?: throw IllegalArgumentException(
                ERROR_NO_MATCHED_DIRECTION.format(value.toString())
            )
        }

        fun getByDisplayName(displayName: String): Direction {
            return Direction.values().firstOrNull { it.displayName == displayName } ?: throw IllegalArgumentException(
                ERROR_NO_MATCHED_DIRECTION.format(displayName)
            )
        }
    }
}
