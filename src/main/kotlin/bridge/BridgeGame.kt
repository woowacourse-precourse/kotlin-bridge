package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    val currentMoving = mutableListOf<String>()
    private val judgement = Judgement()

    fun createCorrectBridgeMap(size: Int) {
        judgement.createCorrectBridge(size)
    }

    fun judgeMovingSuccess(): Boolean {
        return judgement.judgeMovingSuccess(currentMoving)
    }

    fun checkGameOver(): Boolean {
        return judgement.checkGameOver(currentMoving)
    }

    fun move(moving: String): List<String> {
        currentMoving.add(moving)
        return currentMoving.toList()
    }

    fun retry() {}

    fun checkGameWin(): Boolean {
        return judgement.checkGameWin(currentMoving)
    }
}
