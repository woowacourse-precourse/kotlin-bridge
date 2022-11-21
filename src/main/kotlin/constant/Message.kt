package constant

enum class Message(val message: String) {
    GAME_START("다리 건너기 게임을 시작합니다."),

    BRIDGE_SIZE_INPUT("다리의 길이를 입력해주세요."),
    MOVING_INPUT("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    GAME_COMMAND_INPUT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),

    BASIC_ERROR("[ERROR] "),
    BRIDGE_SIZE_ERROR("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    MOVING_ERROR("이동할 칸은 U 또는 D여야 합니다."),
    COMMAND_ERROR("R 또는 Q를 입력하여야 합니다."),

    FINAL_GAME_RESULT("최종 게임 결과"),
    GAME_SUCCESS_RESULT("게임 성공 여부: "),
    SUCCESS("성공"),
    FAIL("실패"),
    NUMBER_OF_ATTEMPTS("총 시도한 횟수: ")
}