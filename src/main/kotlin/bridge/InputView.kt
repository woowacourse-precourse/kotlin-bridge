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
        println("다리의 길이를 입력해주세요.")
        while(true) {
            try {
                return sizeException(readLine())
            } catch (e: IllegalArgumentException) {
                continue
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        return ""
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return ""
    }

    private fun sizeException(size: String?) : Int{
        require(!size.isNullOrEmpty()) { println(ERROR_NULL) }
        val regex = "[0-9]+".toRegex()
        require(size.matches(regex)) { println(ERROR_NOT_NUMBER) }
        require(size.toInt() in 3..20) { println(ERROR_NOT_INRANGE) }
        return size.toInt()
    }

    companion object {
        const val ERROR_NULL = "[ERROR] 아무것도 입력하지 않았습니다. 다시 입력해주세요."
        const val ERROR_NOT_NUMBER = "[ERROR] 숫자를 입력해 주세요."
        const val ERROR_NOT_INRANGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."
    }
}
