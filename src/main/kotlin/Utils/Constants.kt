package Utils

object Constants {
    const val RETRY = "R"
    const val QUIT = "Q"
    const val UP = "U"
    const val DOWN = "D"
    const val TYPE_MOVING = "moving"
    const val TYPE_COMMAND = "command"
    const val TYPE_BRIDGE_SIZE = "bridgeSize"

    // ERROR
    const val ERROR_OUT_OF_RANGE_MESSAGE = "[ERROR] 다리 길이는 3-20 사이의 숫자여야 합니다."
    const val ERROR_NOT_NUMBER_MESSAGE = "[ERROR] 숫자를 입력해주세요."

    const val ERROR_NOT_INPUT_U_OR_D = "[ERROR] U 또는 D를 입력해주세요."
    const val ERROR_NOT_INPUT_R_OR_Q = "[ERROR] R 또는 Q를 입력해주세요."
}