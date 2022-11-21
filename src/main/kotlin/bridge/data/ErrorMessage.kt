package bridge.data

object ErrorMessage {

    private const val ERROR = "[ERROR] "

    const val ERROR_NUM_NOT_IN_RANGE = ERROR.plus("3 ~ 20 사이의 값을 입력해야 합니다.")
    const val ERROR_NOT_NUMBERS = ERROR.plus("숫자를 입력해야 합니다.")
    const val ERROR_NOT_UP_DOWN = ERROR.plus("U나 D를 입력해야 합니다.")
    const val ERROR_NOT_RETRY_QUIT = ERROR.plus("R이나 Q를 입력해야 합니다.")
}