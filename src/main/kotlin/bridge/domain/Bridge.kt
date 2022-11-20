package bridge.domain

import bridge.utils.ONE
import bridge.utils.ZERO

data class Bridge(
    var up: String = "",
    var down: String = "",
    var size: Int = ZERO
) {
    fun setUpBridge(result: String) {
        up += result
    }

    fun setDownBridge(result: String) {
        down += result
    }

    fun setBridgeSize() {
        size += ONE
    }

    fun resetBridge() {
        size = ZERO
        up = ""
        down = ""
    }
}
