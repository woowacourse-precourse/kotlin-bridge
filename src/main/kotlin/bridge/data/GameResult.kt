package bridge.data

data class GameResult(
    val isSuccess: Boolean,
    val tryCount: Int,
    val lastHistory: GameHistory,
)