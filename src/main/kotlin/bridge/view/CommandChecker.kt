package bridge.view

import constant.Message
import constant.Symbol

class CommandChecker(private val input: String?) {
    fun checkAll(): Boolean {
        try {
            checkValue()
        } catch (e: IllegalArgumentException) {
            println(Message.BASIC_ERROR.message + Message.COMMAND_ERROR.message)
            return true
        }
        return false
    }

    private fun checkValue() {
        if (input != Symbol.RETRY.symbol && input != Symbol.QUIT.symbol) {
            throw IllegalArgumentException()
        }
    }
}