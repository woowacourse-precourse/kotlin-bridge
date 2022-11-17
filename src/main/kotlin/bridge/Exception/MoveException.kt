package bridge.Exception

import bridge.resources.*

object MoveException {
    fun exceptions(moveInput: String) {
        if (nullException(moveInput)) throw IllegalArgumentException(ERROR_INPUT_MOVE_NULL)
        if (sizeException(moveInput)) throw IllegalArgumentException(ERROR_INPUT_MOVE_SIZE)
        if (digitException(moveInput)) throw IllegalArgumentException(ERROR_INPUT_MOVE_DIGIT)
    }

    fun nullException(moveInput: String): Boolean {
        return moveInput.isEmpty()
    }

    fun sizeException(moveInput: String): Boolean {
        return moveInput.length != INPUT_MOVE_SIZE
    }

    private fun digitException(moveInput: String): Boolean {
        if (moveInput == UP || moveInput == DOWN) return false
        return true
    }
}