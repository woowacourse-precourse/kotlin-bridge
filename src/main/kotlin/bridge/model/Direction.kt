package bridge.model

enum class Direction(private val value: Int, private val command: String) {
    UP(1, "U"), DOWN(0, "D");

    override fun toString() = this.command

    companion object {
        private const val ERROR_NON_EXIST_DIRECTION_FORMAT = "%s와 일치하는 방향이 없습니다."
        fun getByValue(value: Int): Direction {
            return Direction.values()
                .firstOrNull { it.value == value }
                ?: throw IllegalArgumentException(ERROR_NON_EXIST_DIRECTION_FORMAT.format(value.toString()))
        }

        fun getByCommand(command: String): Direction {
            return Direction.values()
                .firstOrNull { it.command == command }
                ?: throw IllegalArgumentException(ERROR_NON_EXIST_DIRECTION_FORMAT.format(command))
        }
    }
}
