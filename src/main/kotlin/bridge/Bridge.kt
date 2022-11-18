package bridge

class Bridge(private val size: Int) {

    private val bridgeResult = BridgeResult()
    private var success = 0

    fun move(input: BridgeDirection, bridgeMap: List<String>, idx: Int) {
        val mark = movePossibleMark(movePossible(input, bridgeMap, idx))
        bridgeResult.setMoveResult(input, mark)
    }

    fun movePossible(input: BridgeDirection, bridgeMap: List<String>, idx: Int): Boolean {
        return input.name.equals(bridgeMap[idx])
    }

    fun movePossibleMark(isPossible: Boolean): String {
        when (isPossible) {
            true -> {
                success++
                return MOVE_POSSIBLE_MARK
            }
            false -> return MOVE_IMPOSSIBLE_MARK
        }
    }
    fun getGameResult(): Int = success

    fun getUpBridgeResult(): String = bridgeResult.upBridgeResult()

    fun getDownBridgeResult(): String = bridgeResult.downBridgeResult()


    companion object {
        const val MOVE_POSSIBLE_MARK = "O"
        const val MOVE_IMPOSSIBLE_MARK = "X"
    }
}