package bridge.model

class BridgeResult(private val size: Int) {

    private val upBridge = mutableListOf<String>()
    private val downBridge = mutableListOf<String>()
    private val gameResult = GameResult()
    private lateinit var movePossible: Move

    fun setMoveResult(input: BridgeDirection, movePossible: Move) {
        when (input) {
            BridgeDirection.U -> moveUp(movePossible.getMark())
            BridgeDirection.D -> moveDown(movePossible.getMark())
        }
        gameResult.setGameResult(movePossible)
        this.movePossible = movePossible
    }

    fun getMovePossible(): Move = movePossible

    fun moveUp(mark: String) {
        addUpBridge(mark)
        downBridge.add(BLANK_SPACE)
    }

    fun moveDown(mark: String) {
        addUpBridge(BLANK_SPACE)
        downBridge.add(mark)
    }

    fun addUpBridge(mark: String) {
        upBridge.add(mark)
    }


    fun upBridgeResult(): String {
        return upBridge.joinToString(
            prefix = BRIDGE_PREFIX, separator = BRIDGE_SEPARATOR, postfix = BRIDGE_POSTFIX
        )
    }

    fun downBridgeResult(): String {
        return downBridge.joinToString(prefix = BRIDGE_PREFIX, separator = BRIDGE_SEPARATOR, postfix = BRIDGE_POSTFIX)
    }

    fun getGameResult(): Result {
        return gameResult.checkGameSuccess(size)
    }

    companion object {
        const val BRIDGE_PREFIX = "[ "
        const val BRIDGE_SEPARATOR = " | "
        const val BRIDGE_POSTFIX = " ]"
        const val BLANK_SPACE = " "
    }
}