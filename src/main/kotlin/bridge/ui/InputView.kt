package bridge.ui

import bridge.utils.*
import camp.nextstep.edu.missionutils.Console
import java.util.*

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        val bridgeSize = Console.readLine()
        validateBridgeSize(bridgeSize)
        return bridgeSize.toInt()
    }

    private fun validateBridgeSize(bridgeSize: String) {
        // 숫자인지 검사
        handleMixedCharCase(bridgeSize)

        // 3~20의 범위에 속하는지 검사
        handleOutOfRangeCase(bridgeSize.toInt())
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

    private fun handleMixedCharCase(token: String) {
        try {
            for (ch in token) {
                if (!Character.isDigit(ch))
                    throw IllegalArgumentException(MIXED_CHAR_ERROR_MSG)
            }
        }catch (e: IllegalArgumentException){
            println(e.message)
            println(INPUT_RETRY_MSG)
            readBridgeSize()
        }
    }

    private fun handleOutOfRangeCase(num: Int) {
        try {
            if (num !in MIN_SIZE..MAX_SIZE)
                throw IllegalArgumentException(RANGE_BOUNDS_ERROR_MSG)
        }catch (e: IllegalArgumentException){
            println(e.message)
            println(INPUT_RETRY_MSG)
            readBridgeSize()
        }
    }
}
