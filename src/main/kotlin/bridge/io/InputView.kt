package bridge.io


import bridge.resources.*
import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView(private val validChecker: ValidChecker = ValidChecker()) {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        println(SIZE_INPUT_MSG)
        val size: Int
        try {
            size = Console.readLine().toInt()
            validChecker.checkBridgeSize(size)
        } catch (e: IllegalArgumentException) {
            println(ERROR_CODE+ SIZE_ERROR)
            return readBridgeSize()
        }
        return size
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        println(STEP_INPUT_MSG)
        val choice: String
        try {
            choice = Console.readLine()
            validChecker.checkUorD(choice)
        } catch (e: IllegalArgumentException) {
            println(ERROR_CODE+ STEP_ERROR)
            return readMoving()
        }
        return choice
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): Boolean {
        println(RETRY_INPUT_MSG)
        val retry: Boolean
        try {
            val coin = Console.readLine()
            retry = validChecker.checkRorQ(coin)
        } catch (e: IllegalArgumentException) {
            println(ERROR_CODE+ COMMAND_ERROR)
            return readGameCommand()
        }
        return retry
    }
}
