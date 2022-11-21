package bridge.model

class Bridge(private val bridge: List<String>) {

    init {
        require(bridge.all {
            it == "D" || it == "U"
        })
    }

    fun move(idx: Int, direction: String): BridgeResult {
        if (bridge[idx] == direction && idx + 1 == bridge.size) return BridgeResult.FINISH
        if (bridge[idx] == direction) return BridgeResult.SUCCESS
        return BridgeResult.FAIL
    }
}