package bridge.util

import bridge.util.Constant.BRIDGE_MAX_SIZE
import bridge.util.Constant.BRIDGE_MIN_SIZE
import bridge.util.Constant.CAN_MOVE_BRIDGE
import bridge.util.Constant.ERROR_COMMAND
import bridge.util.Constant.ERROR_NUMBER
import bridge.util.Constant.ERROR_RANGE
import bridge.util.Constant.ERROR_SELECT_BRIDGE
import bridge.util.Constant.GAME_COMMAND

object Validator {

    fun checkBridgeSize(size: String) {
        if (size.toIntOrNull() == null) {
            throw IllegalArgumentException(ERROR_NUMBER)
        }

        var bridgeSize = size.toInt()

        if (bridgeSize !in BRIDGE_MIN_SIZE..BRIDGE_MAX_SIZE) {
            throw IllegalArgumentException(ERROR_RANGE)
        }
    }

    fun checkBridgeSelect(move: String) {
        if (move !in CAN_MOVE_BRIDGE) {
            throw IllegalArgumentException(ERROR_SELECT_BRIDGE)
        }
    }

    fun checkCommand(command: String) {
        if (command !in GAME_COMMAND) {
            throw IllegalArgumentException(ERROR_COMMAND)
        }
    }
}