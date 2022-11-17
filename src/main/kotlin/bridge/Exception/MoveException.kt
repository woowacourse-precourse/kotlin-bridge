package bridge.Exception

import bridge.resources.*

object MoveException {
    fun exceptions(moveInput: String) {
        if (nullException(moveInput)) throw IllegalArgumentException(ERROR_INPUT_MOVE_NULL)
        if (sizeException(moveInput)) throw IllegalArgumentException(ERROR_INPUT_MOVE_SIZE)
        if (digitException(moveInput)) throw IllegalArgumentException(ERROR_INPUT_MOVE_DIGIT)
    }

    fun nullException(moveInput: String): Boolean {
        if (moveInput.isEmpty()) {
            println(ERROR_INPUT_MOVE_NULL)
            return true
        }
        return false
    }

    fun sizeException(moveInput: String): Boolean {
        if (moveInput.length != INPUT_MOVE_SIZE) {
            println(ERROR_INPUT_MOVE_SIZE)
            return true
        }
        return false
    }

    private fun digitException(moveInput: String): Boolean {
        if (moveInput == UP || moveInput == DOWN) return false
        println(ERROR_INPUT_MOVE_DIGIT)
        return true
    }
}