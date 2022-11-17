package bridge

import bridge.Constant.ANSWER
import bridge.Constant.DOWN
import bridge.Constant.EMPTY
import bridge.Constant.ERROR_MESSAGE
import bridge.Constant.FALL
import bridge.Constant.UP

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    var upBridge: MutableList<String> = mutableListOf<String>()
    var downBridge: MutableList<String> = mutableListOf<String>()
    var isSuccess = true
    var totalCount: Int = 1
    var count: Int = 0

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(moveAnswer: String, moveOrder: String) {
        when (moveAnswer) {
            UP -> if (moveOrder == UP) upMove(true) else upMove(false)
            DOWN -> if (moveOrder == DOWN) downMove(true) else downMove(false)
            else -> throw IllegalArgumentException(ERROR_MESSAGE)
        }
        count++
    }

    fun upMove(isCorrect: Boolean) {
        isSuccess = if (isCorrect) {
            upBridge.add(ANSWER)
            downBridge.add(EMPTY)
            true
        } else {
            upBridge.add(EMPTY)
            downBridge.add(FALL)
            false
        }
    }

    fun downMove(isCorrect: Boolean) {
        isSuccess = if (isCorrect) {
            upBridge.add(EMPTY)
            downBridge.add(ANSWER)
            true
        } else {
            upBridge.add(FALL)
            downBridge.add(EMPTY)
            false
        }
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {}
    fun isGameEnd(bridge: List<String>): Boolean {
        if (!isSuccess) return true
        if (count == bridge.size) return true
        return false
    }
}
