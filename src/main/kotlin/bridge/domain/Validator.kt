package bridge.domain

import bridge.util.ErrorMessage.ERROR_NOT_VALID_COMMAND
import bridge.util.ErrorMessage.ERROR_NOT_VALID_NUMBER
import java.lang.IllegalArgumentException

object Validator {

    /**
     * 다리 길이 유효성 검사
     */
    fun isValidBridgeSize(input: String): Int {
        val regex = Regex("^[3-9]\$|^1[0-9]\$|^20\$")
        if (!input.matches(regex)) {
            throw IllegalArgumentException(ERROR_NOT_VALID_NUMBER)
        }

        return input.toInt()
    }

    /**
     * 플레이어 이동 유효성 검사
     */
    fun isValidMoving(input: String): String {
        if (!(input == "U" || input == "D")) {
            throw IllegalArgumentException(ERROR_NOT_VALID_COMMAND)
        }

        return input
    }
}
