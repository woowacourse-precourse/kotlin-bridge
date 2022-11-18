package constant

enum class Message(val message: String) {
    GAME_START("다리 건너기 게임을 시작합니다."),

    BRIDGE_SIZE_INPUT("다리의 길이를 입력해주세요."),
    MOVING_INPUT("이동할 칸을 선택해주세요. (위: U, 아래: D)"),

    BASIC_ERROR("[ERROR] "),
    BRIDGE_SIZE_ERROR("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    MOVING_ERROR("이동할 칸은 U 또는 D여야 합니다.")
}