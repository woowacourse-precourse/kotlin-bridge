package bridge.domain

class BridgeGame(private val answerBridge: List<String>) {
    private var position = 0
    private var tryCount = 1

    fun getPosition(): Int = this.position
    fun getTryCount(): Int = this.tryCount

    fun nextPosition() {
        position += 1
    }

    fun getAnswerBridge() = answerBridge

    fun move(direction: String): Boolean {
        if (answerBridge[position] == direction) {
            return true
        }
        return false
    }

    fun retry() {
        position = 0
        tryCount++
    }
}
