package bridge

object Exception {
    private const val ERROR = "[ERROR] "
    private const val ERROR_NUM_NOT_IN_RANGE = ERROR.plus("3 ~ 20 사이의 값을 입력해야 합니다.")
    private const val ERROR_NOT_NUMBERS = ERROR.plus("숫자를 입력해야 합니다.")
    private const val ERROR_NOT_UP_DOWN = ERROR.plus("U나 D를 입력해야 합니다.")
    private const val ERROR_NOT_RETRY_QUIT = ERROR.plus("R이나 Q를 입력해야 합니다.")
    private const val ERROR_NO_GAME = ERROR.plus("게임이 한번도 실행되지 않았습니다.")
    fun String.inputTypeException(): Int {
        try {
            return this.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ERROR_NOT_NUMBERS)
        }
    }

    fun Int.inputRangeException() {
        require(this in 3..20) { ERROR_NUM_NOT_IN_RANGE }
    }

    fun Int.inputNoGameException() {
        require(this > 0) { ERROR_NO_GAME }
    }

    fun String.inputUpDownException() {
        require(this in listOf("U", "D")) { ERROR_NOT_UP_DOWN }
    }

    fun String.inputRetryQuitException() {
        require(this in listOf("R", "Q")) { ERROR_NOT_RETRY_QUIT }
    }
}