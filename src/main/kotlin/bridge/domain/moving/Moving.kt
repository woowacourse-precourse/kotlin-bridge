package bridge.domain.moving

import bridge.common.BRIDGE_NUMBER_DOWN
import bridge.common.BRIDGE_NUMBER_UP
import bridge.common.MOVING_DOWN_CODE
import bridge.common.MOVING_UP_CODE

enum class Moving(val bridgeNumber: Int, val code: String) {
    UP(BRIDGE_NUMBER_UP, MOVING_UP_CODE),
    DOWN(BRIDGE_NUMBER_DOWN, MOVING_DOWN_CODE)
}