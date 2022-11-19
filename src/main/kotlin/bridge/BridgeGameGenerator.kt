package bridge

interface BridgeGameGenerator {
    fun move(moveOrder: String)
    fun upMove(isCorrect: Boolean)
    fun downMove(isCorrect: Boolean)
    fun retry()
    fun isGameEnd(): Boolean
    fun getTotalCount(): Int
    fun getSuccessResult(): Boolean
    fun getDownBridge(): MutableList<String>
    fun getUpBridge(): MutableList<String>
}