package bridge

import javax.swing.TransferHandler.MOVE

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(private val bridgeMaker: BridgeMaker, private val size: Int) {
    /*private*/ val bridge = bridgeMaker.makeBridge(size)
    private var round = 1
    private var curBridge = Pair(BRACE_OPEN,BRACE_OPEN)

    fun getCurBridge() = curBridge
    fun getRound() = round
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(Moving: String, count: Int) {
        if (Moving == "U" && bridge[count] == "U") curBridge =  updateMap(Pair(MOVE_CORRECT, MOVE_NOT_CHOOSE))
        if (Moving == "U" && bridge[count] == "D") curBridge =  updateMap(Pair(MOVE_WRONG, MOVE_NOT_CHOOSE))
        if (Moving == "D" && bridge[count] == "U") curBridge =  updateMap(Pair(MOVE_NOT_CHOOSE, MOVE_WRONG))
        if (Moving == "D" && bridge[count] == "D") curBridge =  updateMap(Pair(MOVE_NOT_CHOOSE, MOVE_CORRECT))
    }

    private fun updateMap(Moving: Pair<String, String>) : Pair<String, String> {
        if (!curBridge.first.contains(BRACE_CLOSE) && !curBridge.second.contains(BRACE_CLOSE)) return Pair(curBridge.first + Moving.first + BRACE_CLOSE, curBridge.second + Moving.second + BRACE_CLOSE)
        return Pair(curBridge.first.removeSuffix(BRACE_CLOSE)  + BRACE_PIPE + Moving.first + BRACE_CLOSE, curBridge.second.removeSuffix(BRACE_CLOSE) + BRACE_PIPE + Moving.second + BRACE_CLOSE)
    }

    fun isFailed() : Boolean {
        return curBridge.first.contains(MOVE_WRONG) || curBridge.second.contains(MOVE_WRONG)
    }

    fun isFinished(count: Int) : Boolean {
        return count == size && !isFailed()
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry(gameCommand: String): Boolean {
        if (gameCommand != "R") return false
        round++
        curBridge = Pair(BRACE_OPEN,BRACE_OPEN)
        return true
    }

    companion object {
        private const val BRACE_OPEN = "["
        private const val BRACE_PIPE = "|"
        private const val BRACE_CLOSE = "]"

        private const val MOVE_CORRECT = " O "
        private const val MOVE_WRONG   = " X "
        private const val MOVE_NOT_CHOOSE = "   "
    }
}
