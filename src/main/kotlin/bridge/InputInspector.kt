package bridge

import values.Moving
import values.Retry

class InputInspector {

    fun checkBridgeSize(input: String): Boolean {
        if (input.length in 1..2 &&
            input.all { it in '0'..'9' } &&
            input.toInt() in 3..20
        ) {
            return true
        } else {
            throw IllegalArgumentException()
        }
    }

    fun checkMoving(input: String): Boolean {
        if (input == Moving.UP.message || input == Moving.DOWN.message) {
            return true
        } else {
            throw IllegalArgumentException()
        }
    }

    fun checkGameCommand(input: String): Boolean {
        if (input == Retry.TRY.message || input == Retry.NOT.message) {
            return true
        } else {
            throw IllegalArgumentException()
        }
    }

}