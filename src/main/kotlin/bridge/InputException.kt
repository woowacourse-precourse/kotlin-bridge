package bridge

import bridge.Model.Constants.Companion.DOWN
import bridge.Model.Constants.Companion.QUIT
import bridge.Model.Constants.Companion.RETRY
import bridge.Model.Constants.Companion.UP
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

class InputException {

    fun checkInputIsNull(input: String) {
        require(input.isNotEmpty()) { ERROR_HEADER + ERROR_NULL_INPUT }
    }

    fun checkBridgeLenInputIsNumeric(input: String) {
        try {
            input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ERROR_HEADER + ERROR_BRIDGE_LEN_INPUT)
        }
    }

    fun checkDirectionInput(input: String) {
        require(input.contains(UP) || input.contains(DOWN)) { ERROR_HEADER + ERROR_BRIDGE_DIRECTION_INPUT }
    }

    fun checkRetryCommandInput(input: String) {
        require(input.contains(RETRY) || input.contains(QUIT)) { ERROR_HEADER + ERROR_RETRY_COMMAND_INPUT }
    }

    fun checkBridgeRange(input: String) {
        require(input.toInt() >= 3 && input.toInt() <= 20) { ERROR_HEADER + ERROR_BRIDGE_RANGE }
    }

    companion object {
        const val ERROR_HEADER = "[ERROR] "

        const val ERROR_NULL_INPUT = "입력된 값이 없습니다."
        const val ERROR_BRIDGE_LEN_INPUT = "다리 길이는 숫자만 가능합니다."
        const val ERROR_BRIDGE_DIRECTION_INPUT = "이동할 칸은 U, D로만 입력 가능합니다."
        const val ERROR_RETRY_COMMAND_INPUT = "재시도 여부는 R, Q로만 답할 수 있습니다."
        const val ERROR_BRIDGE_RANGE = "다리 길이는 3부터 20 사이의 숫자여야 합니다."
    }

}