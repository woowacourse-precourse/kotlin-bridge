package bridge.views

import bridge.constants.Constant.Companion.DOWN_LINE
import bridge.constants.Constant.Companion.START_INDEX
import bridge.constants.Constant.Companion.UP_LINE
import bridge.constants.String.Companion.STRING_BRIDGE_DIVIDER
import bridge.constants.String.Companion.STRING_BRIDGE_END
import bridge.constants.String.Companion.STRING_BRIDGE_START
import bridge.constants.String.Companion.STRING_INPUT_LENGTH
import bridge.constants.String.Companion.STRING_INPUT_MOVING
import bridge.constants.String.Companion.STRING_INPUT_RETRY
import bridge.constants.String.Companion.STRING_PRINT_RESULT
import bridge.constants.String.Companion.STRING_PRINT_SUCCESS_OR_FAIL
import bridge.constants.String.Companion.STRING_PRINT_TRY_NUMBER
import bridge.constants.String.Companion.STRING_START_GAME
import bridge.domain.Flag

class OutputView {
    fun printMap(process: MutableList<MutableList<String>>) {
        printUpLine(process[UP_LINE])
        printDownLine(process[DOWN_LINE])
    }

    fun printUpLine(process: MutableList<String>) {
        var upLine = STRING_BRIDGE_START
        for (index in START_INDEX until process.size) {
            upLine += process[index] + addDivider(index, process.size)
        }
        upLine += STRING_BRIDGE_END
        println(upLine)
    }

    fun printDownLine(process: MutableList<String>) {
        var downLine = STRING_BRIDGE_START
        for (index in START_INDEX until process.size) {
            downLine += process[index] + addDivider(index, process.size)
        }
        downLine += STRING_BRIDGE_END
        println(downLine)
    }

    fun addDivider(index: Int, size: Int): String {
        if (index < size - 1) {
            return STRING_BRIDGE_DIVIDER
        }
        return ""
    }

    fun printResult(tryCount: Int, process: MutableList<MutableList<String>>, flag: Flag) {
        println(STRING_PRINT_RESULT)
        printMap(process)
        println(STRING_PRINT_SUCCESS_OR_FAIL + flag.string)
        println(STRING_PRINT_TRY_NUMBER + tryCount)
    }

    fun printStart() {
        println(STRING_START_GAME)
    }

    fun printInputBridgeLength() {
        println(STRING_INPUT_LENGTH)
    }

    fun printInputMoving() {
        println(STRING_INPUT_MOVING)
    }

    fun printInputRetry() {
        println(STRING_INPUT_RETRY)
    }

    fun printException(message: String) {
        println(message)
    }
}
