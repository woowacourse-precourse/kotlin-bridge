package bridge.model

enum class BridgeGameCommand(val command: String) {
    QUIT("Q"), RETRY("R");

    companion object {
        private const val ERROR_COMMAND_MATCH = "커맨드가 올바르지 않습니다."
        fun getByCommand(command: String): BridgeGameCommand {
            return BridgeGameCommand.values().firstOrNull { it.command == command } ?: throw IllegalArgumentException(
                ERROR_COMMAND_MATCH
            )
        }
    }
}
