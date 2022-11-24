package bridge.domain.game

data class BridgeGameResult(
    val isSuccess: Boolean,
    val tryCount: Int,
    val crossingMap: BridgeCrossingMap,
)