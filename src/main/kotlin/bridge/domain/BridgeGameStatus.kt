package bridge.domain

enum class BridgeGameStatus {
    SUCCESS,
    FAILURE,
    ERROR,
    RUNNING,
    RETRY,
    QUIT;

    companion object {
        fun getStatus(bridgeGameResult: BridgeGameInfo): BridgeGameStatus {
            bridgeGameResult.apply {
                return when {
                    stage.size == bridge.size && stage.last() -> SUCCESS
                    stage.size < bridge.size && stage.last().not() -> FAILURE
                    stage.size !in 0..bridge.size -> ERROR
                    else -> RUNNING
                }
            }
        }

        fun setStatus(command: String): BridgeGameStatus {
            return when (command) {
                "R" -> RETRY
                "Q" -> QUIT
                else -> ERROR
            }
        }
    }
}
