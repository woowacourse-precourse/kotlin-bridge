package bridge.Model

import bridge.Model.BridgeData.bridgeLocation
import bridge.Model.BridgeData.bridgeShape
import bridge.Model.BridgeData.getShape



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