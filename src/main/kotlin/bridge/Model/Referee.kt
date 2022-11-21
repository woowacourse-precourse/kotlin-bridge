package bridge.Model

import bridge.Model.BridgeData.bridgeLocation
import bridge.Model.BridgeData.bridgeShape
import bridge.Model.BridgeData.getShape

enum class BridgeResult(
    private val selectBridge: String,
    private val bridgeState: String
) {
    UP_WIN("U", "U"),
    UP_LOSE("U", "D"),
    DOWN_WIN("D", "D"),
    DOWN_LOSE("D", "U")
}

class Referee() {
    fun judgeMove(selectBridge: String): BridgeResult {
        var shape = getShape(bridgeLocation)
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
            return BridgeResult.DOWN_LOSE
        }
        return BridgeResult.UP_LOSE
    }

    fun judgeLastBridge(nowLocation: Int): Boolean {
        if (nowLocation == bridgeShape.size) {
            return true
        }
        return false
    }
}