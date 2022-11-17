package bridge

class Bridge(private val size: Int) {

    private val upBridge = mutableListOf<String>()
    private val downBridge = mutableListOf<String>()
    private var idx : Int = 0


    fun move(input: String, bridgeMap: List<String>) {
        when(input) {
            "U" -> moveUp(input, bridgeMap)
            "D" -> moveDown(input, bridgeMap)
        }
        idx++
    }

    fun moveUp(input : String, bridgeMap : List<String>) {
        upBridge.add(movePossibleMark(movePossible(input, bridgeMap)))
        downBridge.add(" ")
    }

    fun moveDown(input : String, bridgeMap : List<String>) {
        downBridge.add(movePossibleMark(movePossible(input, bridgeMap)))
        upBridge.add(" ")
    }

    fun movePossible(input : String, bridgeMap : List<String>) : Boolean {
        return input.equals(bridgeMap[idx])
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