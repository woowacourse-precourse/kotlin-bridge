package bridge.Model

import bridge.Model.BridgeData.bridgeLocation

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    private val MOVE = "O"
    private val MISS = "X"
    private val NOT_CHOICE = " "

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move() {
        bridgeLocation++
    }

    fun getResult(result: BridgeResult): Pair<String, String> {
        return when (result) {
            BridgeResult.UP_WIN -> Pair(MOVE, NOT_CHOICE)
            BridgeResult.DOWN_WIN -> Pair(NOT_CHOICE, MOVE)
            BridgeResult.UP_LOSE -> Pair(MISS, NOT_CHOICE)
            BridgeResult.DOWN_LOSE -> Pair(NOT_CHOICE, MISS)
        }
    }

    fun makeUpDownResult(roundResult: BridgeResult) {
        var (up, down) = getResult(roundResult)
        upResult.add(up)
        downResult.add(down)
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {}

    companion object {
        var upResult = mutableListOf<String>()
        var downResult = mutableListOf<String>()
    }
}
