package bridge.model

class BridgeResult {
    private val bridgeMap: BridgeMap = BridgeMap()
    private var totalCount: Int = 1

    fun restart() {
        bridgeMap.clear()
        totalCount++
    }

    fun getTotalCount(): Int = totalCount

    fun getBridgeMap(): String = bridgeMap.toString()

    fun update(result: BridgeStatus) {
        bridgeMap.update(result)
    }

}