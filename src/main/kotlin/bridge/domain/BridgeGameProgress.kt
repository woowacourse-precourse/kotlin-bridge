package bridge.domain

import bridge.resources.ERROR_INPUT_VALID

enum class BridgeGameProgress {
    SUCCESS,
    FAILURE,
    RUNNING;

    companion object {
        fun of(bridgeGameResult: BridgeGameInfo): BridgeGameProgress {
            bridgeGameResult.apply {
                if (stage.isEmpty()) { return RUNNING }
                require(stage.isNoFalseExceptLast()) { ERROR_INPUT_VALID }
                return when {
                    stage.size < bridge.size && stage.last() -> RUNNING
                    stage.size == bridge.size && stage.last() -> SUCCESS
                    stage.size <= bridge.size && stage.last().not() -> FAILURE
                    else -> throw IllegalArgumentException(ERROR_INPUT_VALID)
                }
            }
        }

        private fun List<Boolean>.isNoFalseExceptLast() = this.subList(0, this.size - 1).all { it }
    }
}
