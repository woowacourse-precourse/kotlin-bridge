package bridge.views

import bridge.constants.Constant.Companion.MAX_BRIDGE_LENGTH
import bridge.constants.Constant.Companion.MIN_BRIDGE_LENGTH
import bridge.constants.Exception.Companion.EXCEPTION_INVALID_MOVING
import bridge.constants.Exception.Companion.EXCEPTION_INVALID_RANGE_NUMBER
import bridge.constants.Exception.Companion.EXCEPTION_INVALID_RETRY
import bridge.constants.Exception.Companion.EXCEPTION_IS_NOT_NUMBER
import bridge.constants.String.Companion.STRING_DOWN
import bridge.constants.String.Companion.STRING_QUIT
import bridge.constants.String.Companion.STRING_RETRY
import bridge.constants.String.Companion.STRING_UP
import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

class InputView {
    private val outputView = OutputView()

    fun readBridgeLength(): Int {
        outputView.printInputBridgeLength()
        val length = Console.readLine()
        checkBridgeLength(length)
        return length.toInt()
    }

    fun checkBridgeLength(length: String) {
        if (!length.all { Character.isDigit(it) }) {
            outputView.printException(EXCEPTION_IS_NOT_NUMBER)
            throw IllegalArgumentException(EXCEPTION_IS_NOT_NUMBER)
        }
        if (length.toInt() < MIN_BRIDGE_LENGTH || length.toInt() > MAX_BRIDGE_LENGTH) {
            outputView.printException(EXCEPTION_INVALID_RANGE_NUMBER)
            throw IllegalArgumentException(EXCEPTION_INVALID_RANGE_NUMBER)
        }
    }

    fun readMoving(): String {
        outputView.printInputMoving()
        val moving = Console.readLine()
        checkMoving(moving)
        return moving
    }

    fun checkMoving(moving: String) {
        val valid = listOf<String>(STRING_UP, STRING_DOWN)
        if (!valid.contains(moving)) {
            outputView.printException(EXCEPTION_INVALID_MOVING)
            throw IllegalArgumentException(EXCEPTION_INVALID_MOVING)
        }
    }

    fun readGameRetry(): String {
        outputView.printInputRetry()
        val command = Console.readLine()
        checkGameRetry(command)
        return command
    }

    fun checkGameRetry(command: String) {
        val valid = listOf<String>(STRING_RETRY, STRING_QUIT)
        if (!valid.contains(command)) {
            outputView.printException(EXCEPTION_INVALID_RETRY)
            throw IllegalArgumentException(EXCEPTION_INVALID_RETRY)
        }
    }
}
