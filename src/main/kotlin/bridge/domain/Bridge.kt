package bridge.domain

import bridge.utils.NO_VAULE
import bridge.utils.ONE
import bridge.utils.ZERO

data class Bridge(
    var up: String = NO_VAULE,
    var down: String = NO_VAULE,
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
        up = NO_VAULE
        down = NO_VAULE
    }
}
