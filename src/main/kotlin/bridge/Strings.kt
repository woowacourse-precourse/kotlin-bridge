package bridge

enum class Strings(val phrases: String) {
    GAME_START("다리 건너기 게임을 시작합니다."),
    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    INPUT_BRIDGE_DIRECTION("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_RESTART("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),


    ERROR_INPUT_SIZE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    ERROR_INPUT_DIRECTION("[ERROR] 이동할 칸은 U 와 R 중에서 입력해야 합니다."),
    ERROR_INPUT_RESTART("[ERROR] 재시작 여부는 재시도 - R / 종료 - Q를 입력해야 합니다."),


}