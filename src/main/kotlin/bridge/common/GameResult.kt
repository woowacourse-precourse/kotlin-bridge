package bridge.common

data class GameResult(
    val upperBlocks: List<String>,
    val downerBlocks: List<String>,
    val gameState: GameState,
    val tryCount: Int
)
