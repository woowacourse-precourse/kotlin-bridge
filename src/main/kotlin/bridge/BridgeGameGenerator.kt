package bridge

interface BridgeGameGenerator {
    fun move(moveOrder: String)
    fun upMove(isCorrect: Boolean)
    fun downMove(isCorrect: Boolean)
    fun retry()
    fun isGameEnd(): Boolean
}