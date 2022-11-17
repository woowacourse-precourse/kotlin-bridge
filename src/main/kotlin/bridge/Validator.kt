package bridge

class Validator {

    fun checkBridgeLength(input: String?) {
        checkInputNull(input)
        checkEmptyInput(input!!)
        checkLengthIsNum(input)
        checkLengthRange(input)
    }

    fun checkEmptyInput(input: String) {
        require(input != "") { EMPTY_INPUT_ERROR_MSG }
    }

    fun checkInputNull(input: String?) {
        require(input != null) { INPUT_NULL_ERROR_MSG }
    }

    fun checkLengthIsNum(input: String) {
        try {
            input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(BRIDGE_LENGTH_NOT_NUM_ERROR_MSG)
        }
    }

    fun checkLengthRange(input: String) {
        val length = input.toInt()
        require(length >= BRIDGE_LENGTH_MIN && length <= BRIDGE_LENGTH_MAX) {
            BRIDGE_LENGTH_RANGE_ERROR_MSG
        }
    }

    fun checkMoveDirectionInUAndD(input: String) {
        require(input.equals(BRIDGE_DIRECTION_DOWN) or input.equals(BRIDGE_DIRECTION_UP)) {
            MOVE_DIRECTION_VALUE_ERROR_MSG
        }
    }


    companion object {
        const val BRIDGE_LENGTH_MIN = 3
        const val BRIDGE_LENGTH_MAX = 20
        const val BRIDGE_DIRECTION_UP = "U"
        const val BRIDGE_DIRECTION_DOWN = "D"

        const val ERROR_MSG = "[ERROR]"
        const val EMPTY_INPUT_ERROR_MSG = ERROR_MSG + " 값이 입력되지 않았습니다."
        const val INPUT_NULL_ERROR_MSG = ERROR_MSG + " 값이 null입니다."
        const val BRIDGE_LENGTH_NOT_NUM_ERROR_MSG = ERROR_MSG + " 다리 길이는 숫자여야 합니다."
        const val BRIDGE_LENGTH_RANGE_ERROR_MSG = ERROR_MSG + " 다리 길이는 3부터 20 사이의 숫자여야 합니다."
        const val MOVE_DIRECTION_VALUE_ERROR_MSG = ERROR_MSG + " U(위 칸)와 D(아래 칸) 중 하나의 문자만 입력해야합니다."
    }
}