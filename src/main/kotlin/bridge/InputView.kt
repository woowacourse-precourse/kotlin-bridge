package bridge

import java.lang.IllegalArgumentException

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        println("\n다리의 길이를 입력해주세요.")
        return try {
            sizeException(readLine())
        } catch (e: IllegalArgumentException) {
            readBridgeSize()
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
        return try {
            moveException(readLine())
        } catch (e: IllegalArgumentException) {
            readMoving()
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
        return try {
            commandException(readLine())
        } catch (e: IllegalArgumentException) {
            readGameCommand()
        }
    }

    private fun sizeException(size: String?): Int {
        require(!size.isNullOrEmpty()) { println(ERROR_NULL) }
        val regex = "[0-9]+".toRegex()
        require(size.matches(regex)) { println(ERROR_NOT_NUMBER) }
        require(size.toInt() in 3..20) { println(ERROR_NOT_INRANGE) }
        return size.toInt()
    }

    private fun moveException(move: String?): String {
        require(!move.isNullOrEmpty()) { println(ERROR_NULL) }
        require(move == "U" || move == "D") { println(ERROR_NOT_U_D) }
        return move
    }

    private fun commandException(command: String?): String {
        require(!command.isNullOrEmpty()) { println(ERROR_NULL) }
        require(command == "R" || command == "Q") { println(ERROR_NOT_R_Q) }
        return command
    }

    companion object {
        const val ERROR_NULL = "[ERROR] 아무것도 입력하지 않았습니다. 다시 입력해주세요."
        const val ERROR_NOT_NUMBER = "[ERROR] 숫자를 입력해 주세요."
        const val ERROR_NOT_INRANGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."
        const val ERROR_NOT_U_D = "[ERROR] U 또는 D 를 입력해주세요."
        const val ERROR_NOT_R_Q = "[ERROR] R 또는 Q 를 입력해주세요."
    }
}
