package bridge.view

import bridge.*

class Validator {
    fun validateBridgeSize(bridgeSize: String) {
        val bridgeLength = validatorNumeric(bridgeSize)
        validatorRange(bridgeLength)
    }

    fun validatorMove(move: String?): Boolean {
        if (move == UP || move == DOWN) {
            return true
        }
        throw IllegalArgumentException(ERROR_MOVING)
    }

    fun validatorGameCommand(command: String): Boolean {
        if (command == RETRY || command == QUIT) {
            return true
        }
        throw IllegalArgumentException(ERROR_GAME_COMMAND)
    }

    private fun validatorNumeric(input: String): Int {
        try {
            return input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ERROR_BRIDGE_SIZE_STRING)
        }
    }

    private fun validatorRange(input: Int): Boolean {
        if (input in MIN_BRIDGE_SIZE..MAX_BRIDGE_SIZE) {
            return true
        }
        throw IllegalArgumentException(ERROR_BRIDGE_SIZE)
    }

}