package bridge

import Utils.Constants.DOWN
import Utils.Constants.ERROR_NOT_INPUT_R_OR_Q
import Utils.Constants.ERROR_NOT_INPUT_U_OR_D
import Utils.Constants.ERROR_NOT_NUMBER_MESSAGE
import Utils.Constants.ERROR_OUT_OF_RANGE_MESSAGE
import Utils.Constants.QUIT
import Utils.Constants.RETRY
import Utils.Constants.TYPE_BRIDGE_SIZE
import Utils.Constants.TYPE_COMMAND
import Utils.Constants.TYPE_MOVING
import Utils.Constants.UP

class Rule {
    fun checkValue(input: String, type: String) {
        when (type) {
            TYPE_BRIDGE_SIZE -> checkBridgeSize(input)
            TYPE_MOVING -> checkMoving(input)
            TYPE_COMMAND -> checkCommand(input)
        }
    }

    private fun checkBridgeSize(input: String) {
        val bridgeSize = input.toIntOrNull() ?: throw IllegalArgumentException(ERROR_NOT_NUMBER_MESSAGE)

        if (bridgeSize < RANGE_LOWER_INCLUSIVE || bridgeSize > RANGE_UPPER_INCLUSIVE)
            throw IllegalArgumentException(ERROR_OUT_OF_RANGE_MESSAGE)
    }

    private fun checkMoving(moving: String) {
        if (moving != UP && moving != DOWN)
            throw IllegalArgumentException(ERROR_NOT_INPUT_U_OR_D)
    }

    private fun checkCommand(command: String) {
        if (command != RETRY && command != QUIT)
            throw IllegalArgumentException(ERROR_NOT_INPUT_R_OR_Q)
    }

    companion object {
        const val RANGE_LOWER_INCLUSIVE = 3
        const val RANGE_UPPER_INCLUSIVE = 20
    }
}