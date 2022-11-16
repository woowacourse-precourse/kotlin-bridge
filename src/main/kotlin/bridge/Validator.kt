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

    companion object {
        const val ERROR_MSG = "[ERROR]"
        const val EMPTY_INPUT_ERROR_MSG = ERROR_MSG + " 값이 입력되지 않았습니다."
        const val INPUT_NULL_ERROR_MSG = ERROR_MSG +  " 값이 null입니다."
        const val BRIDGE_LENGTH_NOT_NUM_ERROR_MSG = ERROR_MSG + " 다리길이는 숫자여야 합니다."
    }
}