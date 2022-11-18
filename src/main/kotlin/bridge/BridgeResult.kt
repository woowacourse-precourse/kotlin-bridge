package bridge

class BridgeResult {

    private val upBridge = mutableListOf<String>()
    private val downBridge = mutableListOf<String>()

    fun setMoveResult(input : BridgeDirection, mark : String) {
        when(input) {
            BridgeDirection.U -> moveUp(mark)
            BridgeDirection.D -> moveDown(mark)
        }
    }

    fun moveUp(mark : String) {
        upBridge.add(mark)
        downBridge.add(" ")
    }

    fun moveDown(mark: String) {
        downBridge.add(mark)
        upBridge.add(" ")
    }

    fun upBridgeResult() : String {
        return upBridge.joinToString(prefix = "[ ", separator = " | ", postfix = " ]")
    }

    fun downBridgeResult() : String {
        return downBridge.joinToString(prefix = "[ ", separator = " | ", postfix = " ]")
    }
}