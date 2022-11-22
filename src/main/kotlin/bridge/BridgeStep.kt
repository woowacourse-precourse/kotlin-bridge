package bridge

import bridge.constants.Constants.DOWN_BRIDGE_NUMBER
import bridge.constants.Constants.DOWN_BRIDGE_STRING
import bridge.constants.Constants.UP_BRIDGE_NUMBER
import bridge.constants.Constants.UP_BRIDGE_STRING
import java.lang.IllegalArgumentException

enum class BridgeStep(val bridgeNumber: Int, val bridgeString: String) {
    UP_STEP(UP_BRIDGE_NUMBER, UP_BRIDGE_STRING),
    DOWN_STEP(DOWN_BRIDGE_NUMBER, DOWN_BRIDGE_STRING);

    companion object {
        fun convertBridgeNumberToString(bridgeNumber: Int): String {
            return values().find { bridgeStep ->
                bridgeStep.bridgeNumber == bridgeNumber
            }?.bridgeString ?: throw IllegalArgumentException("[ERROR] U 또는 D만 입력해야 합니다.")
        }
    }
}
