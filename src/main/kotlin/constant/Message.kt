package constant

enum class Message(val message: String) {
    GAME_START("다리 건너기 게임을 시작합니다."),
    BRIDGE_SIZE_INPUT("다리의 길이를 입력해주세요."),
    BRIDGE_SIZE_ERROR("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.")
}