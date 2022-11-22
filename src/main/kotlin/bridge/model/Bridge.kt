package bridge.model

class Bridge(private val bridge: List<String>) {

    init {
        require(bridge.all {
            it == "D" || it == "U"
        })
    }

    fun move(idx: Int, direction: String): BridgeStatus {
        require(direction == "U" || direction == "D")
        if (bridge[idx] == direction && idx + 1 == bridge.size) return BridgeStatus.FINISH(direction)
        if (bridge[idx] == direction) return BridgeStatus.SUCCESS(direction)
        return BridgeStatus.FAIL(direction)
    }
}