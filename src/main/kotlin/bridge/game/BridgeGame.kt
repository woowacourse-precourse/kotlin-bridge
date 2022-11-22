package bridge.game

import bridge.resources.ClEAR
import bridge.resources.FAIL

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(
    private val answerWay: List<String>,
    private var myBridge: Bridge,
    private var status: Status
) {
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     */
    fun move(): Boolean {
        myBridge.choiceStep()
        return myBridge.move(answerWay)
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    private fun retry() {
        status.tryCount++
        myBridge.clearBridge()
        play()
    }

    fun play() {
        while (move()) {
            if (myBridge.getMyWaySize() >= answerWay.size) { //성공
                status.success = ClEAR
                showResult()
                return
            }
        }
        if (myBridge.sendGameCommand()) return retry() // 재시도 묻기
        status.success = FAIL
        showResult()
    }

    fun showResult() {
        myBridge.showResult(answerWay, status.success, status.tryCount)
    }

}
