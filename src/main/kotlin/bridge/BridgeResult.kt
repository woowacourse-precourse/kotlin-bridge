package bridge

class BridgeResult(private val size : Int) {

    private val upBridge = mutableListOf<String>()
    private val downBridge = mutableListOf<String>()
    private val gameResult = GameResult()

    fun setMoveResult(input : BridgeDirection, movePossible : Move) {
        when(input) {
            BridgeDirection.U -> moveUp(movePossible.name)
            BridgeDirection.D -> moveDown(movePossible.name)
        }
        gameResult.setGameResult(movePossible)
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

    fun getGameResult() : Result {
        return gameResult.checkGameSuccess(size)
    }
}