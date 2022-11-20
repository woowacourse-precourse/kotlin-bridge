package bridge.Model

enum class BridgeResult (
    private val selectBridge: String,
    private val bridgeState: String
    ) {
    UP_WIN("U", "U"),
    UP_LOSE("U", "D"),
    DOWN_WIN("D", "D"),
    DOWN_LOSE("D","U")
}

class Referee(private val bridgeShapes: List<String>, private val location: Int) {
    fun judgeMove(selectBridge: String): BridgeResult {
        var shape = bridgeShapes[location]
        if (shape == selectBridge) {
            return judgeWinResult(selectBridge)
        }
        return judgeLoseResult(selectBridge)
    }

    fun judgeWinResult(selectBridge: String): BridgeResult {
        if (selectBridge == "D") {
            return BridgeResult.DOWN_WIN
        }
        return BridgeResult.UP_WIN
    }

    fun judgeLoseResult(selectBridge: String): BridgeResult {
        if (selectBridge == "D") {
            return BridgeResult.UP_LOSE
        }
        return BridgeResult.DOWN_LOSE
    }

    fun judgeLastBridge(nowLocation: Int): Boolean {
        if (nowLocation == bridgeShapes.size-1){
            return true
        }
        return false
    }
}