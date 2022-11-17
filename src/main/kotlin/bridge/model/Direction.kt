package bridge.model

enum class Direction(private val value: Int) {
    UP(1) {
        override fun toString() = "U"
    },
    DOWN(0) {
        override fun toString() = "D"
    };

    companion object {
        fun valueOf(value: Int): Direction {
            return Direction.values()
                .firstOrNull { it.value == value }
                ?: throw IllegalArgumentException(ERROR_NO_MATCHED_DIRECTION.format(value))
        }

        fun names() = Direction.values().map { it.toString() }

        private const val ERROR_NO_MATCHED_DIRECTION = "%d와 맞는 Direction이 없습니다."
    }
}