package bridge.views

import bridge.constants.Exception.Companion.EXCEPTION_INVALID_MOVING
import bridge.constants.Exception.Companion.EXCEPTION_INVALID_RANGE_NUMBER
import bridge.constants.Exception.Companion.EXCEPTION_INVALID_RETRY
import bridge.constants.Exception.Companion.EXCEPTION_IS_NOT_NUMBER
import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    private val outputView = OutputView()

    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeLength(): Int {
        outputView.printInputBridgeLength()
        val length = Console.readLine()
        checkBridgeLength(length)
        return length.toInt()
    }

    fun checkBridgeLength(length: String) {
        if (!length.all { Character.isDigit(it) }) {
            throw IllegalArgumentException(EXCEPTION_IS_NOT_NUMBER)
        }
        if (length.toInt() < 3 || length.toInt() > 20) {
            throw IllegalArgumentException(EXCEPTION_INVALID_RANGE_NUMBER)
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        outputView.printInputMoving()
        val moving = Console.readLine()
        checkMoving(moving)
        return moving.uppercase()
    }

    fun checkMoving(moving: String) {
        val valid = listOf<String>("U", "u", "D", "d")
        if (!valid.contains(moving)) {
            throw IllegalArgumentException(EXCEPTION_INVALID_MOVING)
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameRetry(): String {
        outputView.printInputRetry()
        val command = Console.readLine()
        return command.uppercase()
    }

    fun checkGameRetry(command: String) {
        val valid = listOf<String>("R", "r", "Q", "q")
        if (!valid.contains(command)) {
            throw IllegalArgumentException(EXCEPTION_INVALID_RETRY)
        }
    }
}
