package bridge

import constant.Message

class BridgeSizeChecker(private val input: String?) {
    fun checkAll(): Boolean {
        try {
            checkNotNumber()
            checkRange()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return true
        }
        return false
    }

    private fun checkNotNumber() {
        if(input?.toIntOrNull() == null) {
            throw IllegalArgumentException(Message.BRIDGE_SIZE_ERROR.message)
        }
    }

    private fun checkRange() {
        if(input?.toIntOrNull() !in 3..20) {
            throw IllegalArgumentException(Message.BRIDGE_SIZE_ERROR.message)
        }
    }
}