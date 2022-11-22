package bridge.domain

import bridge.resources.ERROR_INPUT_VALID

enum class BridgeGameCommand(val command: String) {
    RETRY("R"),
    QUIT("Q"),
    NONE("NONE");

    companion object {
        fun of(command: String): BridgeGameCommand {
            return values().find { it.command == command } ?: throw IllegalArgumentException(ERROR_INPUT_VALID)
        }

        fun getCommandList(): List<String> {
            return BridgeGameCommand.values().map { it.command }
        }
    }
}
