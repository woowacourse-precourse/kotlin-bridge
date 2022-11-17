package bridge

class Bridge(private val size: Int) {

    private val upBridge = mutableListOf<String>()
    private val downBridge = mutableListOf<String>()
    private val idx : Int = 0


    fun moveUp(input : String, bridgeMap : List<String>) {
        upBridge.add(movePossibleMark(movePossible(input, bridgeMap)))
        downBridge.add(" ")
    }

    fun movePossible(input : String, bridgeMap : List<String>) : Boolean {
        return input.equals(bridgeMap[idx])
    }

    fun movePossibleMark(isPossible : Boolean) : String = when(isPossible) {
        true -> MOVE_POSSIBLE_MARK
        false -> MOVE_IMPOSSIBLE_MARK
    }

    companion object {
        const val MOVE_POSSIBLE_MARK = "O"
        const val MOVE_IMPOSSIBLE_MARK = "X"
    }
}