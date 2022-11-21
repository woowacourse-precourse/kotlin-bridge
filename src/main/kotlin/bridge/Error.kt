package bridge

enum class Error(val errorMessage: String) {
    NO_ERROR(""),
    BRIDGE_SIZE_ERROR("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    NUMERIC_ERROR("[ERROR] 숫자 형태의 입력이어야 합니다."),
    MOVE_INPUT_ERROR("[ERROR] 방향은 U혹은 D로만 입력할 수 있습니다."),
    RETRY_FLAG_ERROR("[ERROR] 게임을 다시 시도할지에 대한 선택은 R혹은 Q로만 입력할 수 있습니다.")
}