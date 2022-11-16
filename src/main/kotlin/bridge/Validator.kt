package bridge

class Validator {

    fun checkEmptyInput(input: String) {
        require(input != "") { EMPTY_INPUT_ERROR_MSG }
    }

    fun checkInputNull(input: String?) {
        require(input != null) { INPUT_NULL_ERROR_MSG }
    }

    fun checkLengthIsNum(input: String) {
        try {
            input.toInt()
        } catch (e : NumberFormatException) {
            throw IllegalArgumentException(BRIDGE_LENGTH_NOT_NUM_ERROR_MSG)
        }
    }

    fun checkLengthRange(input: String) {
        val length = input.toInt()
        require(length >= BRIDGE_LENGTH_MIN && length <= BRIDGE_LENGTH_MAX) {
            BRIDGE_LENGTH_RANGE_ERROR_MSG
        }
    }

    companion object {
        const val BRIDGE_LENGTH_MIN = 3
        const val BRIDGE_LENGTH_MAX = 20

        const val ERROR_MSG = "[ERROR]"
        const val EMPTY_INPUT_ERROR_MSG = ERROR_MSG + " 값이 입력되지 않았습니다."
        const val INPUT_NULL_ERROR_MSG = ERROR_MSG +  " 값이 null입니다."
        const val BRIDGE_LENGTH_NOT_NUM_ERROR_MSG = ERROR_MSG + " 다리 길이는 숫자여야 합니다."
        const val BRIDGE_LENGTH_RANGE_ERROR_MSG = ERROR_MSG + " 다리 길이는 3부터 20 사이의 숫자여야 합니다."
    }
}