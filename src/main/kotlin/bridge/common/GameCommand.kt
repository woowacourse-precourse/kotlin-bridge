package bridge.common

enum class GameCommand {
    R,
    Q;

    companion object {
        private const val INVALID_COMMAND = "[ERROR] 잘못된 명령입니다."
        fun inGameCommand(input: String): GameCommand {
            return values().find { it.name == input } ?: throw IllegalArgumentException(INVALID_COMMAND)
        }
    }
}
