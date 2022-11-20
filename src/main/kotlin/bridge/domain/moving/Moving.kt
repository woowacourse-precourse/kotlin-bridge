package bridge.domain.moving

import bridge.common.BRIDGE_NUMBER_DOWN
import bridge.common.BRIDGE_NUMBER_UP
import bridge.common.MOVING_DOWN_CODE
import bridge.common.MOVING_UP_CODE

enum class Moving(val code: String, val bridgeNumber: Int) {
    UP(code = MOVING_UP_CODE, bridgeNumber = BRIDGE_NUMBER_UP),
    DOWN(code = MOVING_DOWN_CODE, bridgeNumber = BRIDGE_NUMBER_DOWN)
}