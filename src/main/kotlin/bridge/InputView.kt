package bridge

import bridge.constants.ENTER_AGAIN
import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    private val validator = Validator()

    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        while (true) {
            val size = Console.readLine()
            if (catchException { validator.validateBridgeSize(size) })
                return size.toInt()
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        while (true) {
            val move = Console.readLine()
            if (catchException { validator.validateUpAndDown(move) })
                return move
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        while (true) {
            val command = Console.readLine().toString()
            if (catchException { validator.validateRetryAndQuit(command) })
                return command
        }
    }

    private fun catchException(validate: () -> Unit): Boolean {
        try {
            validate()
            return true
        } catch (e: IllegalArgumentException) {
            OutputView().printMessage(ENTER_AGAIN)
        }
        return false
    }
}
