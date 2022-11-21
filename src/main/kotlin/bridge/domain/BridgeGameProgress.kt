package bridge.domain

import bridge.resources.ERROR_INPUT_COMMAND

enum class BridgeGameProgress {
    SUCCESS,
    FAILURE,
    RUNNING;

    companion object {
        fun of(bridgeGameResult: BridgeGameInfo): BridgeGameProgress {
            bridgeGameResult.apply {
                require(stage.isNotEmpty()) { ERROR_INPUT_COMMAND }
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
    }
}
