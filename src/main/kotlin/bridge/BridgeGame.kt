package bridge

import javax.swing.TransferHandler.MOVE

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(private val bridgeMaker: BridgeMaker, private val size: Int) {
    /*private*/ val bridge = bridgeMaker.makeBridge(size)
    private var round = 0

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(curBridge: Pair<String, String>, Moving: String, count: Int) : Pair<String, String> {
        if (Moving == "U" && bridge[count] == "U") return updateMap(curBridge, Pair(MOVE_CORRECT, MOVE_NOT_CHOOSE))
        if (Moving == "U" && bridge[count] == "D") return updateMap(curBridge, Pair(MOVE_WRONG, MOVE_NOT_CHOOSE))
        if (Moving == "D" && bridge[count] == "U") return updateMap(curBridge, Pair(MOVE_NOT_CHOOSE, MOVE_WRONG))
        if (Moving == "D" && bridge[count] == "D") return updateMap(curBridge, Pair(MOVE_NOT_CHOOSE, MOVE_CORRECT))
        return updateMap(curBridge, Pair(MOVE_WRONG, MOVE_WRONG))
    }

    private fun updateMap(curBridge: Pair<String, String>, Moving: Pair<String, String>) : Pair<String, String> {
        if (!curBridge.first.contains("]") && !curBridge.second.contains("]")) return Pair(curBridge.first + Moving.first + "]", curBridge.second + Moving.second + "]")
        return Pair(curBridge.first.removeSuffix("]")  + "|" + Moving.first + "]", curBridge.second.removeSuffix("]") + "|" + Moving.second + "]")
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {}

    companion object {
        private const val MOVE_CORRECT = " O "
        private const val MOVE_WRONG   = " X "
        private const val MOVE_NOT_CHOOSE = "   "
    }
}
