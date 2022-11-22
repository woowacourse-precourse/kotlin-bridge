package bridge.data

sealed class GameResult {
    object Success: GameResult()
    object Failure: GameResult()
}
