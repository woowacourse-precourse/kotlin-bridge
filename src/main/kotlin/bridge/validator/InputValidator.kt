package bridge.validator

import bridge.util.*

object InputValidator {
    fun validateInValidBridgeSize(input: Int) {
        val hasInvalidBridgeSize = (input < 3 || input > 20)
        if (hasInvalidBridgeSize) throw IllegalArgumentException()
    }

    fun validateBridgeSize(): Int {
        while (true) {
            try {
                val bridgeSize = readLine()!!.toInt()
                validateInValidBridgeSize(bridgeSize)
                return bridgeSize
            } catch (e: IllegalArgumentException) {
                println(ERROR_INVALID_SIZE_MESSAGE)
                continue
            }
        }
    }

    fun validateInvalidMoveInput(input: String) {
        val hasInvalidMoveInput = (input != UP_DIRECTION && input != DOWN_DIRECTION)
        if (hasInvalidMoveInput) throw IllegalArgumentException()
    }

    fun validateMoveInput(): String {
        while (true) {
            try {
                val moveInput = readLine()!!
                validateInvalidMoveInput(moveInput)
                return moveInput
            } catch (e: IllegalArgumentException) {
                println(ERROR_INVALID_MOVE_MESSAGE)
                continue
            }
        }
    }

    fun validateInvalidGameCommand(input: String) {
        val hasInvalidGameCommand = (input != QUIT_COMMAND && input != RESTART_COMMAND)
        if (hasInvalidGameCommand) throw IllegalArgumentException()
    }

    fun validateGameCommand(): String {
        while (true) {
            try {
                val gameCommand = readLine()!!
                validateInvalidGameCommand(gameCommand)
                return gameCommand
            } catch (e: IllegalArgumentException) {
                println(ERROR_INVALID_COMMAND_MESSAGE)
                continue
            }
        }
    }
}

