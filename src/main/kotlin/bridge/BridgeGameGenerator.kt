package bridge

interface BridgeGameGenerator {
    fun move(bridge: List<String>, moveOrder: String)
    fun upMove(isCorrect: Boolean)
    fun downMove(isCorrect: Boolean)
    fun retry()
    fun isGameEnd(bridge: List<String>): Boolean
    fun getTotalCount(): Int
    fun getSuccessResult(): Boolean
    fun getDownBridge(): MutableList<String>
    fun getUpBridge(): MutableList<String>
}