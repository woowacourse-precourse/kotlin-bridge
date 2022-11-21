package bridge.Model

import bridge.Model.BridgeData.bridgeLocation

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    private val WIN = "성공"
    private val LOSE = "실패"

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move() {
        bridgeLocation++
        finalResult = WIN
    }

    fun miss() {
        finalResult = LOSE
    }

    fun compareState(select: String): BridgeResult {
        var referee = Referee()
        var result = referee.judgeMove(select)
        BridgeData.roundResult.add(result)
        return result
    }

    fun makeUpDownResult(roundResult: BridgeResult) {
        var up = roundResult.upState
        var down = roundResult.downState
        upResult.add(up)
        downResult.add(down)
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {
        tryCount++
        upResult.clear()
        downResult.clear()
    }

    companion object {
        var upResult = mutableListOf<String>()
        var downResult = mutableListOf<String>()
        var tryCount = 1
        var finalResult = ""
    }
}
