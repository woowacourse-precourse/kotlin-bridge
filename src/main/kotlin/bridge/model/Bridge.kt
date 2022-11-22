package bridge.model

import bridge.utils.ERR_BRIDGE_SYMBOL

class Bridge(private val bridge: List<String>) {

    init {
        require(bridge.all {
            it == BRIDGE_UPPER_SYMBOL || it == BRIDGE_LOWER_SYMBOL
        }) {
            ERR_BRIDGE_SYMBOL
        }
    }

    fun move(idx: Int, direction: String): BridgeStatus {
        require(direction == BRIDGE_UPPER_SYMBOL || direction == BRIDGE_LOWER_SYMBOL) {
            ERR_BRIDGE_SYMBOL
        }
        if (bridge[idx] == direction && idx + 1 == bridge.size) return BridgeStatus.FINISH(direction)
        if (bridge[idx] == direction) return BridgeStatus.SUCCESS(direction)
        return BridgeStatus.FAIL(direction)
    }

    companion object {
        const val BRIDGE_UPPER_SYMBOL = "U"
        const val BRIDGE_LOWER_SYMBOL = "D"
    }

}