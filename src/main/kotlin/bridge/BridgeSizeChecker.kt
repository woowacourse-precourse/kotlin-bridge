package bridge

import constant.Message

class BridgeSizeChecker(private val input: String?) {
    fun checkAll(): Boolean {
        try {
            checkNotNumber()
            checkRange()
        } catch (e: IllegalArgumentException) {
            println(Message.BASIC_ERROR.message + Message.BRIDGE_SIZE_ERROR.message)
            return true
        }
        return false
    }

    private fun checkNotNumber() {
        if(input?.toIntOrNull() == null) {
            throw IllegalArgumentException()
        }
    }

    private fun checkRange() {
        if(input?.toIntOrNull() !in 3..20) {
            throw IllegalArgumentException()
        }
    }
}