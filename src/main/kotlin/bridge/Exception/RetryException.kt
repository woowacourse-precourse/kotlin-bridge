package bridge.Exception

import bridge.resources.*

object RetryException {
    fun exceptions(retryInput: String) {
        if (MoveException.nullException(retryInput)) throw IllegalArgumentException(ERROR_INPUT_MOVE_NULL)
        if (MoveException.sizeException(retryInput)) throw IllegalArgumentException(ERROR_INPUT_MOVE_SIZE)
        if (digitException(retryInput)) throw IllegalArgumentException(ERROR_INPUT_MOVE_DIGIT)
    }

    private fun digitException(moveInput: String): Boolean {
        if (moveInput == RETRY || moveInput == QUIT) return false
        println(ERROR_INPUT_MOVE_DIGIT)
        return true
    }
}