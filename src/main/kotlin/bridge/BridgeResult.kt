package bridge

class BridgeResult(private val size : Int) {

    private val upBridge = mutableListOf<String>()
    private val downBridge = mutableListOf<String>()

    fun setMoveResult(input : BridgeDirection, movePossible : Move) {
        when(input) {
            BridgeDirection.U -> moveUp(movePossible.name)
            BridgeDirection.D -> moveDown(movePossible.name)
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