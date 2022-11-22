package bridge.view

import constant.Message
import constant.Symbol

class MovingChecker(private val input: String?) {
    fun checkAll(): Boolean {
        try {
            checkValue()
        } catch (e: IllegalArgumentException) {
            println(Message.BASIC_ERROR.message + Message.MOVING_ERROR.message)
            return true
        }
        return false
    }

    private fun checkValue() {
        if (input != Symbol.UP.symbol && input != Symbol.DOWN.symbol) {
            throw IllegalArgumentException()
        }
    }
}