package bridge.domain

import bridge.resources.ERROR_INPUT_COMMAND

enum class BridgeGameStatus(val command: String?) {
    SUCCESS(null),
    FAILURE(null),
    RUNNING(null),
    RETRY("R"),
    QUIT("Q");

    companion object {
        fun getStatus(bridgeGameResult: BridgeGameInfo): BridgeGameStatus {
            bridgeGameResult.apply {
                require(stage.isNoFalseExceptLast()) { ERROR_INPUT_COMMAND }
                return when {
                    stage.size < bridge.size && stage.last() -> RUNNING
                    stage.size == bridge.size && stage.last() -> SUCCESS
                    stage.size <= bridge.size && stage.last().not() -> FAILURE
                    else -> throw IllegalArgumentException(ERROR_INPUT_COMMAND)
                }
            }
        }

        private fun List<Boolean>.isNoFalseExceptLast() = this.subList(0, this.size - 1).all { it }

        fun setStatus(command: String): BridgeGameStatus {
            return values().firstOrNull { it.command == command }
                ?: throw IllegalArgumentException(ERROR_INPUT_COMMAND)
        }
    }
}
