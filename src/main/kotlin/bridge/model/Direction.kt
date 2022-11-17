package bridge.model

enum class Direction(private val value: Int) {
    U(1),
    D(0);

    companion object {
        fun valueOf(value: Int): Direction {
            return Direction.values()
                .firstOrNull { it.value == value }
                ?: throw IllegalArgumentException(ERROR_NO_MATCHED_DIRECTION.format(value.toString()))
        }

        fun getByName(name: String): Direction {
            return Direction.values()
                .firstOrNull { it.name == name }
                ?: throw IllegalArgumentException(ERROR_NO_MATCHED_DIRECTION.format(name))
        }

        private const val ERROR_NO_MATCHED_DIRECTION = "%s와 맞는 Direction이 없습니다."
    }
}