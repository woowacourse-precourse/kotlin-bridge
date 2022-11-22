package util

import data.BridgeStore.BRIDGE_UP
import data.BridgeStore.BRIDGE_DOWN
import data.BridgeStore.ERROR_TAG
import data.BridgeStore.QUIT
import data.BridgeStore.RETRY

class InputException {

    fun checkMoveCommand(input: String?) {
        val range = listOf(BRIDGE_UP, BRIDGE_DOWN)
        require(range.contains(input))
    }

    fun checkRetryCommand(input: String?) {
        val range = listOf(RETRY, QUIT)
        require(range.contains(input))
    }

    fun checkRangeException(input: String?) {
        val range = (3..20)
        require(range.contains(input?.toInt()))
    }

    fun printException(message: String) {
        println("$ERROR_TAG $message")
    }
}