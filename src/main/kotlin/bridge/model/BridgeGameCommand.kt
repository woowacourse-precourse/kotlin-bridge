package bridge.model

enum class BridgeGameCommand(private val command: String) {
    QUIT("Q"), RETRY("R");

    companion object {
        private const val ERROR_NON_EXIST_COMMAND_FORMAT = "%s와 일치하는 명령어가 없습니다."
        fun getByCommand(command: String): BridgeGameCommand {
            return BridgeGameCommand.values()
                .firstOrNull { it.command == command }
                ?: throw IllegalArgumentException(ERROR_NON_EXIST_COMMAND_FORMAT.format(command))
        }
    }
}
