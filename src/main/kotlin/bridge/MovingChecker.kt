package bridge

import constant.Message

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
        if (input != "U" && input != "D") {
            throw IllegalArgumentException()
        }
    }
}