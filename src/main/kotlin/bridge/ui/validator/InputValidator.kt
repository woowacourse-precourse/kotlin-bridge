package bridge.ui.validator

import bridge.common.*
import bridge.ui.common.*

object InputValidator {
    fun validateBridgeSize(bridgeSize: String) {
        (bridgeSize.isDigit() && bridgeSize.isCorrectSize()).let { isCorrectBridgeSize ->
            if (!isCorrectBridgeSize) throw IllegalArgumentException(ERROR_BRIDGE_SIZE_MESSAGE)
        }
    }

    fun validateMoving(moving: String) {
        if (!(moving == MOVING_UP_CODE || moving == MOVING_DOWN_CODE))
            throw throw IllegalArgumentException(ERROR_MOVING_MESSAGE)
    }

    fun validateGameCommand(command: String) {
        if (!(command == GAME_RESTART_CODE || command == GAME_QUIT_CODE))
            throw throw IllegalArgumentException(ERROR_GAME_COMMAND_MESSAGE)
    }

    private fun String.isDigit(): Boolean =
        this.all { eachChar -> eachChar.isDigit() }

    private fun String.isCorrectSize(): Boolean =
        this.toInt() in MIN_BRIDGE_SIZE .. MAX_BRIDGE_SIZE

}