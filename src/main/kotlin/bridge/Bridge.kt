package bridge

class Bridge(private val size: Int) {

    private val bridgeResult = BridgeResult()

    fun move(input: BridgeDirection, bridgeMap: List<String>, idx : Int) {
        val mark = movePossibleMark(movePossible(input, bridgeMap, idx))
        bridgeResult.setMoveResult(input, mark)
    }


    fun movePossible(input : BridgeDirection, bridgeMap : List<String>, idx: Int) : Boolean {
        return input.name.equals(bridgeMap[idx])
    }

    fun movePossibleMark(isPossible : Boolean) : String = when(isPossible) {
        true -> MOVE_POSSIBLE_MARK
        false -> MOVE_IMPOSSIBLE_MARK
    }

    fun upBridgeResult() : String {
        return upBridge.joinToString(prefix = "[ ", separator = " | ", postfix = " ]")
    }

    fun downBridgeResult() : String {
        return downBridge.joinToString(prefix = "[ ", separator = " | ", postfix = " ]")
    }

    companion object {
        const val MOVE_POSSIBLE_MARK = "O"
        const val MOVE_IMPOSSIBLE_MARK = "X"
    }
}