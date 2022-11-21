package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    val currentMoving = mutableListOf<String>()
    private val judgement = Judgement()
    var tryCount = FIRST_TRY

    fun createCorrectBridgeMap(size: Int) {
        judgement.createBridge(size)
    }

    fun judgeMovingSuccess(): Boolean {
        return judgement.judgeMovingSuccess(currentMoving)
    }

    fun checkGameOver(): Boolean {
        return judgement.checkGameOver(currentMoving)
    }

    fun move(moving: String) {
        currentMoving.add(moving)
    }

    fun checkGameWin(): Boolean {
        return judgement.checkGameWin(currentMoving)
    }

    fun retry() {
        currentMoving.clear()
        addTryCount()
    }

    private fun addTryCount() {
        tryCount++
    }
}
