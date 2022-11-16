package bridge

class Validator {

    fun checkEmptyInput(input: String) {
        require(input != "") { EMPTY_INPUT_ERROR_MSG }
    }

    companion object {
        const val ERROR_MSG = "[ERROR]"
        const val EMPTY_INPUT_ERROR_MSG = ERROR_MSG + " 값이 입력되지 않았습니다."
    }
}