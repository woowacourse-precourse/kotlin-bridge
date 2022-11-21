package util

enum class Error (val message: String) {
    BRIDGE_LENGTH_INPUT_TYPE_ERROR("[ERROR] 다리 길이는 숫자여야 합니다."),
    MOVE_INPUT_TYPE_ERROR("[ERROR] 이동할 칸은 문자여야 합니다."),
    BRIDGE_LENGTH_INPUT_RANGE_ERROR("[ERROR] 다리 길이는 3 이상 20 이하의 숫자여야 합니다."),
    MOVE_INPUT_LETTER_ERROR("[ERROR] 이동할 칸은 U 또는 D의 문자여야 합니다."),
    RETRY_INPUT_TYPE_ERROR("[ERROR] 입력값은 문자여야 합니다."),
    RETRY_INPUT_LETTER_ERROR("[ERROR] 입력값은 R 또는 Q의 문자여야 합니다."),
    INPUT_NUMBER_ERROR("[ERROR] 입력값은 하나여야 합니다."),
}