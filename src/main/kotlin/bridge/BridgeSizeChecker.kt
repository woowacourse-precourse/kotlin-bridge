package bridge

import constant.Message

class BridgeSizeChecker(private val input: String?) {
    fun checkAll(): Boolean {
        try {
            checkNumber()
            checkRange()
        } catch (e: java.lang.IllegalArgumentException) {
            println(e.message)
            return true
        }
        return false
    }

    private fun checkNumber() {
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