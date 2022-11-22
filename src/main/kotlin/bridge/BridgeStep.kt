package bridge

import bridge.constants.Constants.DOWN_BRIDGE_NUMBER
import bridge.constants.Constants.DOWN_BRIDGE_STRING
import bridge.constants.Constants.UP_BRIDGE_NUMBER
import bridge.constants.Constants.UP_BRIDGE_STRING

enum class BridgeStep(val bridgeNumber: Int, val bridgeString: String) {
    UP_STEP(UP_BRIDGE_NUMBER, UP_BRIDGE_STRING),
    DOWN_STEP(DOWN_BRIDGE_NUMBER, DOWN_BRIDGE_STRING);

    companion object {
        fun convertBridgeNumberToString(bridgeNumber: Int): String {
            return values().filter { bridgeStep ->
                bridgeStep.bridgeNumber == bridgeNumber
            }[0].bridgeString
        }
    }
}
